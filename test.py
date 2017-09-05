import urllib2

r = urllib2.urlopen("http://127.0.0.1:8080/test/hello")

result = r.read()

if(result == "hello world"):
	print("Test Succeeded!    " + result)
else:
	print("Test Failed    " + result)
