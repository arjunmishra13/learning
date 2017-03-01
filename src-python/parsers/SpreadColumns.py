SMALL_VALUE = 10
LARGE_VALUE = 50

def spreadRows(fileName, quoteIndex):
    
    for data in open(fileName):
        temp = data
        index = 0
        str = ""
        count = 1
        while "\t" in temp:
            index = temp.index("\t")
            str += temp[:index] + "," + spaces(len(temp[:index]))
                
#             print len(str)
            
            temp = temp[index + 1:]
            count = count+1
        str += temp[:index] + "," + spaces(len(temp[:index]))
        print str

def spaces(num):
    str = ""
    if num < SMALL_VALUE:
        while num != SMALL_VALUE: 
            str += " "
            num += 1
    else:
        str = ""
        while num != LARGE_VALUE:
            str += " "
            num += 1
    return str
        


if __name__ == '__main__':
    fileName = '/Users/mishra/Desktop/Projects/Notions/TestFiles/MiniSorterRuleInserts.txt'
    spreadRows(fileName, 2)