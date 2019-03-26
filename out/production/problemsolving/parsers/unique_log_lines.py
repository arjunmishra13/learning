import re
import os

# This script is used to identify the unique log lines that repeat several times
# It helps to distinguish log messages, especially if one or two of them
# are the dominant ones
# dirname - location of log file
# level - level you want to analyze
# log_length - length you want to strip. if it is -1, use the entire length
def parseFile(dirname, filename, level, log_length):

  print_level = -1
  if level == "TRACE":
    print_level = 0
  elif level == "DEBUG":
    print_level = 1
  elif level == "INFO":
    print_level = 2
  elif level == "WARN":
    print_level = 3
  elif level == "ERROR":
    print_level = 4
  else:
    print "Invalid Level: " + level
    return

  log_dict = dict()
  if len(filename) == 0:
    for filename in os.listdir(dirname):
      if ".out" not in filename:
        continue
      filename = dirname + "/" + filename
      print "Looking in file\t" + filename

      file = open(filename, 'r')
      for f in file:
        f = re.sub(r'\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2},\d{3} ', '', f)
        if get_level(f) >= print_level:
          if log_length > 0 and log_length < len(f):
            f = f[:log_length]
          else:
            f = f[:len(f) - 1]
          if f not in log_dict:
            log_dict[f] = 0

          log_dict[f] = log_dict.get(f) + 1
  else:
    filename = dirname + '/' + filename
    file = open(filename, 'r')
    for f in file:
      f = re.sub(r'\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2},\d{3} ', '', f)
      if get_level(f) >= print_level:
        if log_length > 0 and log_length < len(f):
          f = f[:log_length]
        else:
          f = f[:len(f) - 1]
        if f not in log_dict:
          log_dict[f] = 0

        log_dict[f] = log_dict.get(f) + 1


  outfile = open(dirname + "/unique_log_analyzer.log", 'w')

  for key, value in log_dict.items():
    outstr = key + "\tcount: " + str(value) + "\n"
    outfile.write(outstr)

  outfile.close()

def get_level(f):
  if "TRACE" in f:
    return 0
  if "DEBUG" in f:
    return 1
  if "INFO" in f:
    return 2
  if "WARN" in f:
    return 3
  if "ERROR" in f:
    return 4

if __name__ == "__main__":
  level = raw_input("Log Level: TRACE, DEBUG, INFO, WARN, or ERROR:\t").strip()
  # dirname = raw_input("Log path directory:\t").strip()
  dirname = "/Users/amishra/Documents/Cloudera/Support/CDH-78437"
  # filename = raw_input("Log path filename:\t").strip()
  # filename = "sentry-SENTRY_SERVER-f524c6d0207e243f10fd95d0b23f5a4a.log"
  filename = ""
  log_length = int(raw_input("Sepcify length you want to filter by. Set -1 if you don't want to specify length\t"))
  parseFile(dirname, filename, level, log_length)