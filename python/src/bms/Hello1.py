x = 5

c1 = "gabriel is in orlando florida"

print len(c1)
print c1
print c1.upper()
print c1.title()

c2 = 'rafael is too'
print c2
print c2 > c1

def count(me):
    print len(me)
    
count(c1)
count(c2)

name = raw_input("What\'s your name?")
quest = raw_input("What is your quest?")
color = raw_input("What is your favorite color?")

print "Your name is %s, your quest is %s, and your "\
"favorite color is %s." % (name, quest, color)