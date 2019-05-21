import sys, os

END_CHARACTER = "\n"

def create_large_seperated_values(num_values, val_str_prefix, val_str_suffix, seperator, outputfile):

  outputF = open(outputfile, 'w')

  longstring = ""
  for i in range(1,num_values + 1):
    if len(val_str_prefix) > 0:
      longstring = longstring + val_str_prefix + str(i)
    else:
      longstring = longstring + str(i)

    if len(val_str_suffix) > 0:
      longstring = longstring + val_str_suffix

    if len(seperator) > 0 and i < num_values:
      longstring = longstring + seperator

  print longstring
  outputF.write(longstring)

  outputF.close();

if __name__ == "__main__":
  num_values = 100
  val_str_prefix = "col"
  val_str_suffix = ""
  seperator = ","
  outputfile = "/Users/amishra/Scripts/output/large_table.txt"
  create_large_seperated_values(num_values, val_str_prefix, val_str_suffix, seperator, outputfile)