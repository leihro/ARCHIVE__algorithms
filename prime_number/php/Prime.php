<?php

	class Prime {
		/**
		 * check prime number 质数
		 * @param  int  $number number to be checked
		 * @return boolean        
		 */
		public function isPrime($number){
			$i = 2;
			if($number == 2) {
				return true;
			}
			// 取n的平方根，用n除以每一个比它小的数，看是否有余数
			$n_sqrt = sqrt($number);
			while ($i<= $n_sqrt) {
				if($number% $i == 0) {
					return false;
				}
				$i++;
			}
			return true;
		}
		/**
		 * 埃拉托斯特尼筛子：筛选出一定范围内的质数
		 * @param  array $sieve input筛子
		 * @param  int $range 上限的值
		 * @return array prime number in range
		 */
		public function eratosthenes_sieve($sieve, $range) {
			$i = 2;
			$arr = array();
			/**
			 * 原理：筛掉全部可以被“小的质数”整除的(标记筛子对应值为1)，从i = 2开始，然后 i = 3, 5, 7, 11...
			 */
			while ($i <= $range) {
				if ($sieve[$i] == 0) {
					$arr[] = $i; //每一个质数从小到大写入arr中

					$j = $i;
					while ($j <= $range) {
						$sieve[$j] = 1; //在筛子中标记能整除"小质数"的位置为1
						$j += $i;
					}
				}
				$i++;
			}
			return $arr;
		}
 	}
 ?>
 <?php 
 	//test
 	$prime = new Prime;
 	$range = 200;
 	$sieve = array_fill(0, $range, 0);
 	$test_number = 89;

 	echo 'Is test number ' . $test_number . ' prime? ' . ($prime->isPrime($test_number) ? 'true' : 'false');
 	echo "<hr />";
 	echo "Print all the prime number smaller than " . $range;
 	echo "<br />";
 	echo "<tt><pre>" . var_export($prime->eratosthenes_sieve($sieve, $range), true) . "</pre></tt>";
 	echo "<br />";

  ?>