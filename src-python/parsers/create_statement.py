import sys

def print_statement(inputfile, outputfile, statement_type, extra):
  if len(statement_type) == 0:
    sys.exit("Enter non-emptuy statement_type")

  inputF = open(inputfile, 'r')
  outputF = open(outputfile, 'w')

  for i in inputF:

    i = i.split("|")[1].strip()
    if "\n" in i:
      i = i[:len(i) - 1]
    if len(extra) != 0 and extra in i:
      str = statement_type + i + ";\n"
    elif len(extra) == 0:
      str = statement_type + i + ";\n"
    else:
      continue
    outputF.write(str)

  outputF.close();

if __name__ == "__main__":
  inputfile = "/Users/amishra/Documents/Cloudera/TestFiles/CDH-63070/sentry_roles.txt"
  outputfile = "/Users/amishra/Documents/Cloudera/TestFiles/CDH-63070/drop_role_commands.txt"
  statement_type = "DROP ROLE "
  extra = "test_"
  print_statement(inputfile, outputfile, statement_type, extra)