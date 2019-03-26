from datetime import datetime
import time

TIMESTAMP_LENGTH = 23
def value_frequency(check_string, start_from_string, outlier_val, file, out_file):

  outf = open(out_file, 'w')
  previos_date = ""
  previous_val = 0
  for f in open(file, 'r'):
    if "\n" in f:
      f = f[:len(f) - 1]

    if len(start_from_string) > 0 and start_from_string in f:
      f = f[f.index(start_from_string) + len(start_from_string):]

    time_str = f[:TIMESTAMP_LENGTH]
    # time_val = time.mktime(getDateTime(time_str).timetuple())
    if check_string in f:
      val_str = f[f.index(check_string) + len(check_string):]
      val_int = int(val_str)

      if len(previos_date) == 0 and previous_val == 0:
        previos_date = time_str
        previous_val = val_int
      else:
        d1 = getDateTime(previos_date)
        d2 = getDateTime(time_str)
        time_diff = int(getMinutesDiff(d1, d2))
        val_diff = abs(val_int - previous_val)
        print_str = time_str + "\t" + str(time_diff) + "\t" + str(val_diff) + "\n"
        outf.write(print_str)
        if val_diff > outlier_val:
          print print_str,
        previos_date = time_str
        previous_val = val_int

  outf.close()



def getSecondsDiff(d1, d2):
  return abs((d1-d2).total_seconds())

def getMinutesDiff(d1, d2):
  return abs((d1-d2).total_seconds())/60


def getDateTime(time):
  return datetime.strptime(time, '%Y-%m-%d %H:%M:%S,%f')

def getTimeStamp(time):
  return time.mktime(getDateTime(time).timetuple())

if __name__ == "__main__":
  file = "/Users/amishra/Documents/Cloudera/TestFiles/sentry-notifications-processed-1.log"
  out_file = "/Users/amishra/Documents/Cloudera/TestFiles/notifications_processed_history-1.txt"
  check_string = "value="
  start_from_string = ".out:"
  outlier_val = 50
  value_frequency(check_string, start_from_string, outlier_val, file, out_file)