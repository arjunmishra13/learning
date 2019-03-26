import sys, os

END_CHARACTER = "\n"
DEFAULT_MAX = -1

def filter_by_max_value(search_string, end_string, inputDir, inputfile):

  max = -sys.maxsize -1
  maxValString = ""
  if len(inputfile) == 0:
    for fileName in os.listdir(inputDir):
      new_maxObj = getMax(search_string, end_string, inputDir + "/" + fileName)
      if new_maxObj != None and max < new_maxObj.maxVal:
        max = new_maxObj.maxVal
        maxValString = new_maxObj.maxValString
  else:
    maxObj = getMax(search_string, end_string, inputfile)
    if maxObj != None:
      max = maxObj.maxVal
      maxValString = maxObj.maxValString
    else:
      max = DEFAULT_MAX

  print "Max value for [" + search_string + "]" + " = " + str(max) + ". String [" + maxValString[:len(maxValString) - 1] + "]"

def getMax(search_string, end_string, fileName):

  max = -sys.maxsize -1
  maxObj = None
  for f in open(fileName, 'r'):
    if search_string in f:
      if len(end_string) == 0:
        val = f[f.index(search_string) + len(search_string):len(f) - 1]
      else:
        val = f[f.index(search_string) + len(search_string):f.index(search_string) + len(search_string) + f.index(end_string)]

      if max < int(val):
        max = int(val)
        maxObj = MaxEntry(int(val), f)

  return maxObj


class MaxEntry:
  maxVal = -sys.maxsize -1
  maxValString = ""

  def __init__(self, maxVal, maxValString):
    self.maxVal = maxVal
    self.maxValString = maxValString



if __name__ == "__main__":
  inputfile = ""
  inputDir = "/Users/amishra/Documents/Cloudera/Support/CDH-73595/sentry_12th"
  search_string = "total number of partitions fetched ="
  end_string = ""
  filter_by_max_value(search_string, end_string, inputDir, inputfile)