<?php 
/**
 * algos about strings and arrays
 */
class StrArr{
	/**
	 * evaluate the reverse polish notation
	 * @param  mixed $array 
	 * @return 
	 */
	public static function eval_rpn($array){
		$stack = new SplStack();
		$op = array('+','-','*','/');
		foreach ($array as $value) {
			$value = trim($value);
			if (is_numeric($value) | in_array($value, $op)) {
				if(!in_array($value, $op)){
					$stack->push($value);
				} else {
					$lastin_1 = $stack->pop();
					$lastin_2 = $stack->pop();
					switch ($value) {
						case '+':
							$stack->push($lastin_2 + $lastin_1);
							break;
						case '-':
							$stack->push($lastin_2 - $lastin_1);
							break;
						case '*':
							$stack->push($lastin_2 * $lastin_1);
							break;
						case '/':
							if($lastin_1 != 0){
								$stack->push($lastin_2 / $lastin_1);
								break;							
							} else {
								return "cannot evaluate reverse polish notation";
							}
						default:
							return "cannot evaluate reverse polish notation";
					}
				}
			} else {
				return "cannot evaluate reverse polish notation";
			}
		}
		$result = $stack->pop();
		return $result;
	}
}

$array = ['1', "2", '-', '3', '*'];
echo StrArr::eval_rpn($array);