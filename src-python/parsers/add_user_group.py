GROUP_STRING = "groups="
COMMA_SEPERATOR = ","
OPEN_BRACKET_SEPERATOR = "("
CLOSE_BRACKET_SEPERATOR = ")"
def add_user_group(inputfile, user_name):
  for i in open(inputfile, 'r'):
    i = i[i.index(GROUP_STRING) + len(GROUP_STRING):]
    for j in i.split(COMMA_SEPERATOR):
      j = j[j.index(OPEN_BRACKET_SEPERATOR) + len(OPEN_BRACKET_SEPERATOR):]
      j = j[:j.index(CLOSE_BRACKET_SEPERATOR)]
      # print "groupadd " + j
      print "usermod -a -G " + j + " " + user_name




if __name__ == "__main__":

  inputfile = "/Users/amishra/Documents/Cloudera/Support/CDH-72659/outputof_id_pjt42845.txt"
  add_user_group(inputfile, "pjt42845")
