package com.example.cloudmusic.beans

class Trotting() {
  var url: String = ""

  constructor(url: String) : this() {
    this.url = url
  }

  override fun toString(): String {
    return "SlideShowItem(url='$url')"
  }
}