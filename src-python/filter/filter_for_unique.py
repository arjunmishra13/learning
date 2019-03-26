END_DELIMITER = "\n"
def filter_for_unique(file, check_string):

  val_dict = {}
  for f in open(file, 'r'):
    if check_string in f:
      strtemp = f[f.index(check_string) + len(check_string):]
      if END_DELIMITER in f:
        strtemp = strtemp[:len(strtemp) - 1]

      if strtemp not in val_dict:
        val_dict[strtemp] = 0

      val_dict[strtemp] = val_dict[strtemp] + 1


  for val in val_dict:
    print val + ":\t" + str(val_dict[val])



if __name__ == "__main__":
  file = "/Users/amishra/Documents/Cloudera/TestFiles/CheckDuplicateCount.txt"
  check_string = "ERROR org.apache.sentry.service.thrift.FullUpdateInitializer: "
  filter_for_unique(file, check_string)