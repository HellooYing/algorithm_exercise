
def pd(s1,s2):
    l1=list(s1)
    l2=list(s2)
    if len(l1)==len(l2):
        #change
        f=0
        for i in range(len(l1)):
            if l1[i]==l2[i]:
                continue
            else:
                f=f+1
        if f==0 or f==1:
             return True
        else:
          return False
    if len(l2)==len(l1)-1:
#delete
        for i in range(len(l2)):
              if l1[i]==l2[i]:
                  continue
              if l1[i]!=l2[i]:
                  if l2[i:]==l1[i+1:]:
                       return True
                  else:
                       return False
       
        return True
    if len(l2)==len(l1)+1:
        for i in range(len(l1)):
            if l1[i]==l2[i]:
                continue
            if l1[i]!=l2[i]:
                if l1[i:]==l2[i+1:]:
                     return True
                else:
                     return False
        return True
    return False


print((pd("1234","234")))