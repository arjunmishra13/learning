
class INEQUALITY:
  greater_than = ">"
  greater_than_or_equal_to = ">="
  lesser_than = "<"
  lesser_than_or_equal_to = "<="

def filter_file_by_inequality(file, check_string, value, inequality):

  for f in open(file, 'r'):
    if "\n" in f:
      f = f[:len(f) - 1]
    if check_string in f:
      val_str = f[f.index(check_string) + len(check_string):]
      val_int = int(val_str)

      if inequality == INEQUALITY.greater_than and val_int > value:
        print f
      elif inequality == INEQUALITY.greater_than_or_equal_to and val_int >= value:
        print f
      elif inequality == INEQUALITY.lesser_than and val_int < value:
        print f
      elif inequality == INEQUALITY.lesser_than_or_equal_to and val_int <= value:
        print f


if __name__ == "__main__":
  file = "/Users/amishra/Documents/Cloudera/TestFiles/sentry_logs_u95_notifications_processed.log"
  check_string = "value="
  value = 1
  inequality = ">"
  filter_file_by_inequality(file, check_string, value, inequality)