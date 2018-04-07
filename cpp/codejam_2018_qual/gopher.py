#!/usr/bin/env python
import sys, math

def fill_rect(center):
    filled = set()
    while len(filled) < 9:
        print 2, center
        sys.stdout.flush()
        res = raw_input()
        if res == "-1 -1":
            return False
        elif res == "0 0":
            return True
        filled.add(res) 
    return False

t = int(raw_input())
for i in xrange(t):
    a = int(raw_input())
    iters = int(math.ceil(a / 9.0))
    done = False
    for j in xrange(iters):
        done = fill_rect(2 + 3 * j)
        if done: break
    if not done:
        print 1, 1
        sys.stdout.flush()
        break
