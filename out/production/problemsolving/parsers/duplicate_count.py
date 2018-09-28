def print_count(filename):
	file = open(filename, 'r')
	values = dict()
	for n in file:
		if "\n" in n:
			n = n[:len(n) - 1]
		
		if n not in values:
			values[n] = 0
		values[n] = values[n] + 1
	
	for key, value in values.items():
		print key + "\t" + str(value)

if __name__ == "__main__":
	filename = "/Users/amishra/Documents/Cloudera/TestFiles/DuplicateValues.txt"
	print_count(filename)