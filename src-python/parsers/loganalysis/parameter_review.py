import operator

COMMA = ","
level_list = []
level_struct = {}
def parameter_review(inputfile, name, level):

  for i in open(inputfile, 'r'):
    if (level in i)and((len(name) > 0 and name in i) or (len(name) == 0)):
      start_index = i.index(level)
      end_index = i[start_index:].index(COMMA) + start_index
      val = i[start_index + len(level) + 1:end_index].strip()
      level_struct[float(val)] = i
      level_list.append(float(val))

def print_values(is_top_values, value):
  if is_top_values:
    level_list.sort(reverse=True)
  else:
    level_list.sort()

  i = 0
  prev = None
  unique = 1
  while (value > 0 and (i < value or unique < value)) or (value == 0 and i < len(level_list)):
    if prev is None or prev != level_list[i]:
      prev = level_list[i]
      unique = unique + 1
      print prev
    i = i + 1

def print_values_with_string(level, is_top_values, value):
  keys = level_struct.keys()
  if is_top_values:
    keys.sort(reverse=True)
  else:
    keys.sort()

  i = 0
  prev = None
  unique = 0
  while (value > 0 and (i < value or unique < value)) or (value == 0 and i < len(keys)):
    if prev is None or prev != keys[i]:
      prev = keys[i]
      unique = unique + 1
      print "{} Time: {}, String: {}".format(level, prev, level_struct[keys[i]].strip())
    i = i + 1

if __name__ == "__main__":

  inputfile = "/Users/amishra/Documents/Cloudera/Support/CDH-72207/HMS_Follower_Metrics.log"
  name = "drop_partition"
  level = "count"
  parameter_review(inputfile, name, level)
  # print_values(True, 20)
  print_values_with_string(level, True, 50)