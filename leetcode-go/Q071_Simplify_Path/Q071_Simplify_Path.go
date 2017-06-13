package Q071_Simplify_Path

import (
	"strings"
)

func simplifyPath(path string) string {
	stack := []string{}
	for _, dir := range strings.Split(path, "/") {
		if dir == ".." && len(stack) != 0 {
			stack = stack[0 : len(stack)-1]
		}
		if dir != ".." && dir != "." && dir != "" {
			stack = append(stack, dir)
		}
	}
	if len(stack) == 0 {
		return "/"
	}
	return "/" + strings.Join(stack, "/")
}
