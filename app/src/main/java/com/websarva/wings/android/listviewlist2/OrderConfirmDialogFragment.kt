package com.websarva.wings.android.listviewlist2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.Toast

class OrderConfirmDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // ダイアログビルダを作成
        val builder = AlertDialog.Builder(activity)
        // ダイアログのタイトル設定
        builder.setTitle(R.string.dialog_title)
        // メッセージ
        builder.setMessage(R.string.dialog_msg)
        // PositiveButton
        builder.setPositiveButton(R.string.dialog_btn_ok, DialogButtonClickListener())
        // Negative Button
        builder.setNegativeButton(R.string.dialog_btn_ng, DialogButtonClickListener())
        // Neutral BUtton
        builder.setNeutralButton(R.string.dialog_btn_nu, DialogButtonClickListener())
        // ダイアログオブジェクト生成
        val dialog = builder.create()
        return dialog

    }

    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface?, which: Int) {
            // トーストメッセージ用文字列変数を用意
            var msg = ""
            // タップされたアクションボタンで分岐
            when (which) {
                // Positive
                DialogInterface.BUTTON_POSITIVE ->
                    // 注文用をメッセ格納
                    msg = getString(R.string.dialog_ok_toast)
                // Negative
                DialogInterface.BUTTON_NEGATIVE ->
                    msg = getString(R.string.dialog_ng_toast)
                // Neutral
                DialogInterface.BUTTON_NEUTRAL ->
                    msg = getString(R.string.dialog_nu_toast)
            }
            // トースト表示
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}