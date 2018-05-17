import operator

def analyze(fileName, writeFileName):
  file = open(fileName, 'r')
  compaction_time_dict = {}
  count = 0
  for f in file:
    s1 = "Compacting Done. Time Taken "
    s2 = "seqNum="
    s3 = ", Partial"
    if s1 in f and s2 in f and s3 in f:
      compaction_time_dict[getVal(f[f.index(s2) + len(s2):f.index(s3)])] = getVal(f[f.index(s1) + len(s1):])
      count = count + 1

  print "Total number of log compaction:\t" + str(count)

  sorted_compaction_time_dict = sorted(compaction_time_dict.items(), key=operator.itemgetter(0))
  writeToFile = open(writeFileName, 'w')
  writeToFile.write("Seq\tTime(ms)\n")
  for key, value in sorted_compaction_time_dict:
    writeToFile.write(str(key) + "\t" + str(value) + "\n")
  writeToFile.close()

def getVal(str):
  return int(str.strip())

if __name__ == "__main__":
  readFileName = '/Users/amishra/Documents/Cloudera/Support/CDH-64672/In-HouseTesting/ScaleTest_HeapSize_10Gb_LogCompThresh_1000/LogAnalysis/LogCompactionTime.log'
  writeFileName = '/Users/amishra/Documents/Cloudera/Support/CDH-64672/In-HouseTesting/ScaleTest_HeapSize_10Gb_LogCompThresh_1000/LogAnalysis/Result_LogCompactionTime.log'
  analyze(readFileName, writeFileName)
