package net.ntworld.intellijCodeCleaner.ui

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JPanel
import java.util.Calendar
import javax.swing.JLabel
import javax.swing.JButton

open class CodeCleanerToolWindow(toolWindow: ToolWindow) {
    private var refreshToolWindowButton: JButton? = null
    private var hideToolWindowButton: JButton? = null
    private var currentDate: JLabel? = null
    private var currentTime: JLabel? = null
    private var timeZone: JLabel? = null
    private var myToolWindowContent: JPanel? = null

    init {
        hideToolWindowButton!!.addActionListener { e -> toolWindow.hide(null) }
        refreshToolWindowButton!!.addActionListener { e -> currentDateTime() }

        this.currentDateTime()
    }

    fun currentDateTime() {
        // Get current date and time
        val instance = Calendar.getInstance()
        currentDate!!.text = (instance.get(Calendar.DAY_OF_MONTH).toString() + "/"
            + (instance.get(Calendar.MONTH) + 1).toString() + "/" +
            instance.get(Calendar.YEAR).toString())
        val min = instance.get(Calendar.MINUTE)
        val strMin: String
        if (min < 10) {
            strMin = "0$min"
        } else {
            strMin = min.toString()
        }
        currentTime!!.text = instance.get(Calendar.HOUR_OF_DAY).toString() + ":" + strMin
        // Get time zone
        val gmt_Offset = instance.get(Calendar.ZONE_OFFSET).toLong() // offset from GMT in milliseconds
        var str_gmt_Offset = (gmt_Offset / 3600000).toString()
        str_gmt_Offset = if (gmt_Offset > 0) "GMT + $str_gmt_Offset" else "GMT - $str_gmt_Offset"
        timeZone!!.text = str_gmt_Offset


    }

    fun getContent(): JPanel? {
        return myToolWindowContent
    }
}