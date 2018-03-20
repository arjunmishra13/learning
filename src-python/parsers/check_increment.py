import sys

def check_increment(filename):

  skip_title = True
  is_first = True
  initial = -1
  initial_txt = ""
  for i in open(filename):
    # To skip the title
    if skip_title:
      skip_title = False
      continue

    if is_first:
      initial = int(i.split(",")[1])
      initial_txt = i
    else:

      if int(i.split(",")[1]) > initial + 1:
        printstr = "INCREMENT: previous values:\t" + initial_txt[:len(initial_txt)-1] + "\tcurrent values:\t" + i[:len(i)-1]
        print printstr
        # sys.exit(printstr)
      initial = int(i.split(",")[1])
      initial_txt = i
    is_first = False


if __name__ == "__main__":
  filename = "/Users/amishra/Documents/Cloudera/Support/CDH-61788/dumps/notifications_log.csv"
  check_increment(filename)