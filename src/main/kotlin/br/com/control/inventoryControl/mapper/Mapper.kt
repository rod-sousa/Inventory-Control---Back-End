package br.com.control.inventoryControl.mapper

interface Mapper<T, U> {

    fun map(p: T): U

}
