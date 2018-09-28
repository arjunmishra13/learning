import sys

STRING1 = "Authorization Request for Subject"
STRING_SERVER = "Server [name="
STRING_DATABAE = "Database [name="
STRING_TABLE = "Table [name="
STRING_COLUMN = "Column [name="
STRING3 = "]]"
def single_line_analyze_columns_needed_authorization(inputfile):
  all_columns = []
  columns_count_map = {}
  total_comparisons = 0
  for i in open(inputfile, 'r'):
    while STRING_COLUMN in i :
      start_index = i.index(STRING_COLUMN) + len(STRING_COLUMN)
      column = i[start_index:]
      end_index = column.index(STRING3)
      column = column[:end_index]
      i = i[start_index + end_index:]
      total_comparisons = total_comparisons + 1
      if column not in all_columns:
        all_columns.append(column)
        columns_count_map[column] = 1
      else:
        columns_count_map[column] = columns_count_map[column] + 1

  print "Total number of comparisons " + str(total_comparisons)
  print "Total Number of Columns " + str(len(all_columns))
  for j in all_columns:
    print j

  print "Duplicates"
  for j in columns_count_map.keys():
    print str(j) + " - " + str(columns_count_map[j])


def analyze_columns_needed_authorization(inputfile):
  all_columns = []
  columns_count_map = {}
  total_comparisons = 0
  for i in open(inputfile, 'r'):
    if STRING1 in i:
      start_index = i.index(STRING_COLUMN) + len(STRING_COLUMN)
      temp = i[start_index:]
      end_index = temp.index(STRING3)
      temp = temp[:end_index]
      if temp not in all_columns:
        all_columns.append(temp)
        columns_count_map[temp] = 1
      else:
        columns_count_map[temp] = columns_count_map[temp] + 1
      total_comparisons = total_comparisons + 1

      # if temp in all_columns:
      #   print i
      #   raise ValueError('Duplicate column ' + temp)
      # else:
      #   all_columns.append(temp)

  print "Total number of comparisons " + str(total_comparisons)

  print "Total Number of Columns " + str(len(all_columns))
  for j in all_columns:
    print j

  print "Duplicates"
  for j in columns_count_map.keys():
    print str(j) + " - " + str(columns_count_map[j])




if __name__ == "__main__":

  inputfile = "/Users/amishra/Documents/Cloudera/Support/CDH-72659/2018_09_13/user_pjt42845.log"
  # analyze_columns_needed_authorization(inputfile)
  inputfile = "/Users/amishra/Desktop/test.log"
  single_line_analyze_columns_needed_authorization(inputfile)