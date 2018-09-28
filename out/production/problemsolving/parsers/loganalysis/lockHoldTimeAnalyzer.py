import operator

def analyze(fileName):
  file = open(fileName, 'r')
  count = 0
  for f in file:
    count = count + 1
    # print f
    s1 = "Time"
    # s1 = "Time Take"
    # s1 = "Time Taken"
    if s1 in f:
      val = getVal(f[f.index(s1) + len(s1):])
      if val > 1:
        print val
        # print f.strip()
  print "\nTotal Count:\t" + str(count)

def getVal(str):
  return float(str.strip())

if __name__ == "__main__":
  # readFileName = '/Users/amishra/Documents/Cloudera/Support/CDH-64672/In-HouseTesting/ScaleTest_HeapSize_10Gb/LogAnalysis/SentryAuthorization_VerifyUpdate_LockTime.log'
  readFileName = '/Users/amishra/Documents/Cloudera/Support/CDH-64672/In-HouseTesting/ScaleTest_HeapSize_10Gb_LogCompThresh_1000/LogAnalysis/SentryAuthorization_VerifyUpdate_LockTime.log'
  analyze(readFileName)
