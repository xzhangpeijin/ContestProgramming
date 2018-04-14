import math

T = int(raw_input())
for t in xrange(T):
    n, p = [int(x) for x in raw_input().split(" ")]
    cur = 0
    rects = []
    for j in xrange(n):
        w, h = [int(x) for x in raw_input().split(" ")]
        rects.append((min(w, h), 2 * math.sqrt(w * w + h * h)))
        cur += 2 * (w + h)
    rects = sorted(rects, key=lambda (mn, mx): mx / mn)
    
    shortest = cur
    longest = cur
    for mn, mx in rects:
        if shortest + mn <= p:
            shortest += mn
            longest += mx
    print "Case #{}: {}".format(t + 1, min(longest, p))
