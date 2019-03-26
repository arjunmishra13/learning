import os
import sys
def analyze_rate(filename, keyword, endchars, print_top_count):

  max_change = 0
  min_change = 0
  total_change = 0
  change_count = 0
  prev_val = 0
  isFirst = True
  isSecond = True
  change_list = []
  file = open(filename, 'r')
  for f in file:
    start_index = f.index(keyword) + len(keyword)
    end_index = f.index(endchars)
    val = int(f[start_index:end_index])
    val_diff = val - prev_val
    prev_val = val
    if val_diff == 0:
      print f
      sys.exit(0)

    if isFirst:
      prev_val = val_diff
      isFirst = False
    else:
      if val_diff < 0:
        prev_val = val
      else:
        if isSecond:
          max_change = val_diff
          min_change = val_diff
          total_change = val_diff
          change_count = change_count + 1
          isSecond = False
        else:
          max_change = max(max_change, val_diff)
          min_change = min(min_change, val_diff)
          total_change = total_change + val_diff
          change_count = change_count + 1

        change_list.append(val_diff)

  change_list.sort(reverse=True)
  for i in range(print_top_count):
    print "Top - " + str(i + 1) + " Value = " + str(change_list[i])
  print "Max Change = " + str(max_change)
  print "Min Change = " + str(min_change)
  print "Mean Change = " + str(total_change/change_count)


if __name__ == "__main__":
  filename = "/Users/amishra/Documents/Cloudera/Support/CDH-75883/sentry1029_transactions.log"
  keyword = "count="
  endchars = ", min="
  print_top_count = 10
  analyze_rate(filename, keyword, endchars, print_top_count)