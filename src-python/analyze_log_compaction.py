import operator
from datetime import datetime

def analyzeLogCompaction(fileName):
  f = open(fileName, 'r')
  durationMap = {}
  countPerDayMap = {}
  occurrenceCount = 0
  countPerDay = 0
  currentDate = datetime.now().date()
  initialString = ""
  for data in f:
    try:
      if currentDate != getDateTime(data[:23]).date():
        if countPerDay != 0:
          countPerDayMap[currentDate] = countPerDay
        currentDate = getDateTime(data[:23]).date()
        countPerDay = 0

      if "UpdateLog Reached Overflow Size" in data:
        initialString = data
        startTime = getDateTime(data[:23])
        countPerDay = countPerDay + 1
      elif "UpdateLog Overflow, Compacting Done" in data:
        endTime = getDateTime(data[:23])
        durationMap[occurrenceCount] = (endTime - startTime).total_seconds()
        occurrenceCount = occurrenceCount + 1
        finalString = data
        if (endTime - startTime).total_seconds() > 20:
          print '{}{}'.format(initialString, data)
    except:
      pass

  f.close()
  printTop10(durationMap)
  printDayCounts(countPerDayMap)
  printCompactionStats(durationMap)


def printTop10(durationMap):
  count = 0
  for k, v in sorted(durationMap.items(), key=operator.itemgetter(1),
                     reverse=True):
    print v
    count = count + 1
    if count > 10:
      break


def printCompactionStats(durationMap):
  max = 0
  sum = 0
  count = 0
  for i in durationMap.values():
    if max < i:
      max = i
    sum = sum + i
    count = count + 1
  print 'max\t{:.2f}, average\t{:.2f}'.format(max, (sum / count))


def printDayCounts(countPerDayMap):
  for date in countPerDayMap.keys():
    print '{}\t{}\t{:.2f}'.format(str(date), str(countPerDayMap[date]), countPerDayMap[date]*1.0/24)


def getDateTime(time):
  return datetime.strptime(time, '%Y-%m-%d %H:%M:%S,%f')

if __name__ == "__main__":
  fileName = "/Users/amishra/Documents/Cloudera/Support/CDH-64672/hadoop-cmf-sentry-SENTRY_SERVER-bdgtmaster03h1p.nam.nsroot.net.log.out"
  analyzeLogCompaction(fileName)
