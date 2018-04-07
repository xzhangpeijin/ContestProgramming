package main

import (
  "fmt"
  "bufio"
  "os"
  "math"
)

func main() {
    reader := bufio.NewReader(os.Stdin)
    line, _ := reader.ReadString('\n')

    var T int
    fmt.Sscanf(line, "%d", &T)
    for i := 0; i < T; i++ {
        line, _ := reader.ReadString('\n')
        var A float64
        fmt.Sscanf(line, "%f", &A)
        if A <= math.Sqrt(2) {
            target := math.Asin(A / math.Sqrt(2)) - math.Pi / 4
            sin := math.Sin(target) / 2.0
            cos := math.Cos(target) / 2.0
            fmt.Printf("Case #%d:\n", i+1)
            fmt.Printf("%.10f %.10f %.10f\n", cos, sin, 0.0)
            fmt.Printf("%.10f %.10f %.10f\n", -sin, cos, 0.0)
            fmt.Printf("%.10f %.10f %.10f\n", 0.0, 0.0, 0.5)
        } else {
            if A > math.Sqrt(3) {
                A = math.Sqrt(3)
            }
            x := (2 * A + math.Sqrt(24 - 8 * A * A) ) / 6
            t := math.Asin(x)
            fac := math.Sqrt(2) / 4
            sin := math.Sin(t)
            cos := math.Cos(t)
            fmt.Printf("Case #%d:\n", i+1)
            fmt.Printf("%.10f %.10f %.10f\n",
                       fac, fac * cos, -fac * sin)
            fmt.Printf("%.10f %.10f %.10f\n",
                       -fac, fac * cos, -fac * sin)
            fmt.Printf("%.10f %.10f %.10f\n",
                       0.0, sin / 2, cos / 2)
        }
    }
}
