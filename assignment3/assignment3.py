
#def And:

#def Not:

#def Implies:

#def Equivalent:

#def Or:


if __name__ == "__main__":

    inputString = "((p1 implies (p2 and p3)) and (not p1) implies (p3 and p4))"
    if "equals" in inputString:
        location = inputString.find('equals')
        
    
    if "implies" in inputString:
        location = inputString.find('implies')

        location = location - 3
        newString = inputString[:location] + 'not ' + inputString[location:]
    
        newString = newString.replace('implies', 'or')

        print(newString)
    
