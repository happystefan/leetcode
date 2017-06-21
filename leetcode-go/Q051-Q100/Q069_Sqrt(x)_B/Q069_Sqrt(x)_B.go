package Q069_Sqrt_x__B

func mySqrt(x int) int {
	y := x
	for y*y > x {
		y = (y+x/y)/2
	}
	return y
}