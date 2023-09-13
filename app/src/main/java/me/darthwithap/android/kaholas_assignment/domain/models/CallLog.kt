package me.darthwithap.android.kaholas_assignment.domain.models

import java.sql.Timestamp
import java.text.SimpleDateFormat

data class CallLog(
    val id: String,
    val phoneNo: String,
    val fromNumber: String,
    val date: Timestamp,
    val durationInSeconds: Int,
    val callType: CALL_TYPE,
    val recordingFileName: String
) {
    companion object {
        private val dateFormat = SimpleDateFormat("yyyyMMddHHmmss")
        val mockDataSet = listOf(
            CallLog(
                "1",
                "+1234567890",
                "+0987654321",
                Timestamp(System.currentTimeMillis() - 884404329),
                120,
                CALL_TYPE.INCOMING,
                "${"001234567890"}(${"000987654321"})_${dateFormat.format(Timestamp(System.currentTimeMillis()))}.mp3"
            ),
            CallLog(
                "2",
                "+1234567890",
                "+1122334455",
                Timestamp(System.currentTimeMillis() - 86400000),
                30,
                CALL_TYPE.OUTGOING,
                "${"001234567890"}(${"001122334455"})_${dateFormat.format(Timestamp(System.currentTimeMillis() - 86400000))}.mp3"
            ),
            CallLog(
                "3",
                "+1234567890",
                "+5566778899",
                Timestamp(System.currentTimeMillis() - 172800000),
                69,
                CALL_TYPE.MISSED,
                "${"001234567890"}(${"005566778899"})_${dateFormat.format(Timestamp(System.currentTimeMillis() - 172800000))}.mp3"
            ),
            CallLog(
                "4",
                "+1234567890",
                "+2233445566",
                Timestamp(System.currentTimeMillis() - 259200000),
                24,
                CALL_TYPE.INCOMING,
                "${"001234567890"}(${"002233445566"})_${dateFormat.format(Timestamp(System.currentTimeMillis() - 259200000))}.mp3"
            ),
            CallLog(
                "5",
                "+1234567890",
                "+3344556677",
                Timestamp(System.currentTimeMillis() - 345600000),
                4329,
                CALL_TYPE.OUTGOING,
                "${"001234567890"}(${"003344556677"})_${dateFormat.format(Timestamp(System.currentTimeMillis() - 345600000))}.mp3"
            )
        )
    }
}

enum class CALL_TYPE {
    INCOMING, OUTGOING, MISSED
}

