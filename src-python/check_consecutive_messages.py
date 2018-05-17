import os

def check_consecutive_messages(directoryName, message, end_message):
  for fileName in os.listdir(directoryName):
    first_message = False
    prev_message = ""
    fileName = directoryName + "/" + fileName
    file = open(fileName, 'r')
    for f in file:
      if message in f:
        if first_message:
          print "Repeated:\t" + prev_message + "\tCurrent:\t" + f
        prev_message = f
        first_message = True
      elif end_message in f:
        first_message = False


if __name__ == "__main__":
  directoryName = '/Users/amishra/Documents/Cloudera/Support/CDH-64672/In-HouseTesting/ScaleTest_HeapSize_10Gb/nn'
  message = "Start getting Updates from Sentry"
  end_message = "Get Updates from Sentry"
  check_consecutive_messages(directoryName, message, end_message)
