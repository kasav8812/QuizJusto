package com.charls.quizjusto.JustoModule


data class JustoProfileModel (
    val results : List<Results>,
    val info : Info
)

class Results(
    val gender : String,
    val name : Name,
    val location: Location,
    val email : String,
    val login: Login,
    val dob: Dob,
    val registered : Registered,
    val phone : String,
    val cell : String,
    val id : ID,
    val picture : Picture,
    val nat : String
)

class Name (
    val title : String,
    val first : String,
    val last : String
    )


class Location(
    val street : Street,
    val city : String,
    val state : String,
    val country : String,
    val postcode : String,
    val coordinates : Coordinates,
    val timezone: Timezone
)

class Street(
    val number : String,
    val name : String
)

class Coordinates(
    val latitude : String,
    val longitude : String
)

class Timezone(
    val offset : String,
    val description : String
)

class Login(
    val uuid : String,
    val username : String,
    val password : String,
    val salt : String,
    val md5 : String,
    val sha1 : String,
    val sha256 : String
)

class Dob(
    val date : String,
    val age : String
)

class Registered(
    val date : String,
    val age : String
)

class ID(
    val name : String,
    val value : String
)

class Picture(
    val large : String,
    val medium : String,
    val thumbnail : String
)

class Info(
    val seed : String,
    val results : String,
    val page : String,
    val version : String
)