package com.klm.fhm.app

import scala.collection.mutable.ListBuffer

class cart {
  var itemList = new ListBuffer[String]
  val itemCost = Map("Apple" -> 60, "Orange" -> 25)

  def addItem(item :String) :Unit = {
    println(item + "added")
    itemList += item
  }
  def checkoutItem() : Float = {
    val costList = itemList.map(x => {
      itemCost(x)
    })
    costList.sum / 100f
  }

  def checkoutPromotion() : Float = {
   val appleCount = itemList.filter( itm => itm == "Apple").size
    val orangeCount = itemList.filter( itm => itm == "Orange").size

    val appleCost = (appleCount /2  * 60) +  (appleCount % 2 * 60)
    val orangeCost = (orangeCount * 2/3  * 25) +  (orangeCount % 3 * 25)

    (appleCost + orangeCost) / 100f
  }


}

object cart {
  def main(args : Array[String]) :Unit = {
    var t = new cart
    t.addItem("Apple")
    t.addItem("Apple")
    t.addItem("Orange")
    t.addItem("Orange")
    t.addItem("Orange")
    t.addItem("Orange")

    println(t.checkoutItem())
    println(t.checkoutPromotion())

  }

}

