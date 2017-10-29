class CustomDate2(year: Int, month: Int, day: Int){
	def m = month match {
		case 1 => 0
		case 2 => 31
		case 3 => 59
		case 4 => 90
		case 5 => 120
		case 6 => 151
		case 7 => 181
		case 8 => 212
		case 9 => 243
		case 10 => 273
		case 11 => 304
		case 12 => 334
	}

	def d: Int = year * 365 + day + m

	override def toString(): String = {
		val year = d / 365
		val mod = (d % 365)
		val month = mod match {
			case x if x < 31 => 1
			case x if x < 59 => 2
			case x if x < 90 => 3
			case x if x < 120 => 4
			case x if x < 151 => 5
			case x if x < 181 => 6
			case x if x < 212 => 7
			case x if x < 243 => 8
			case x if x < 273 => 9
			case x if x < 304 => 10
			case x if x < 334 => 11
			case _ => 12
		}

		val day = month match {
			case 1 => mod
			case 2 => mod - 31
			case 3 => mod - 59
			case 4 => mod - 90
			case 5 => mod - 120
			case 6 => mod - 151
			case 7 => mod - 181
			case 8 => mod - 212
			case 9 => mod - 243
			case 10 => mod - 273
			case 11 => mod - 304
			case 12 => mod - 334
		}

		"%d-%d-%d".format(year, month, day)
	}
}

class CustomDate(year: Int, month: Int, day: Int) {
	def y = year
	def m = month
	def d = day
	
	def compareTo (otherDate: CustomDate): Int = {
		val compY = y - otherDate.y
		val compM = m - otherDate.m
		val compD = d - otherDate.d

		if (compY < 0) -1
		else if (compY > 0) 1
		else if (compM < 0) -1
		else if (compM > 0) 1
		else if (compD < 0) -1
		else if (compD > 0) 1
		else 0
	}

	override def toString(): String = {
		val year = d / 365
		val mod = d % 365
		val month = mod match {
			case x if x < 31 => 1
			case x if x < 59 => 2
			case x if x < 90 => 3
			case x if x < 120 => 4
			case x if x < 151 => 5
			case x if x < 181 => 6
			case x if x < 212 => 7
			case x if x < 243 => 8
			case x if x < 273 => 9
			case x if x < 304 => 10
			case x if x < 334 => 11
			case _ => 12
		}

		val day = month match {
			case 1 => mod
			case 2 => mod - 31
			case 3 => mod - 59
			case 4 => mod - 90
			case 5 => mod - 120
			case 6 => mod - 151
			case 7 => mod - 181
			case 8 => mod - 212
			case 9 => mod - 243
			case 10 => mod - 273
			case 11 => mod - 304
			case 12 => mod - 334
		}

		"%d-%d-%d".format(year, month, day)
	}

	// def + (daysToSum: Int):CustomDate = {
	// 	if (((m<=7)&&(m%2 == 1))||((m>=8)&&(m%2 == 0))) {
	// 		if ((daysToSum + d)>31) {
	// 			 new CustomDate (y,m+1,d-31 +daysToSum)
	// 		}
	// 	}
	// }
}


object CustomDate{
	def fecha(v: Any): Either[String, CustomDate] = 
    if (v.isInstanceOf[CustomDate]) Right(v.asInstanceOf[CustomDate]) else Left("Undefined")
}



object principal{
	def main(args: Array[String]){
		val fecha1: CustomDate2 = new CustomDate2(2017,2,28)
		val fecha2: CustomDate2 = new CustomDate2(2017,12,31)


		println(fecha1 toString)
		println(fecha2 toString)
	}
}


