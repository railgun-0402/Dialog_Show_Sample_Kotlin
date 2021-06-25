package com.websarva.wings.android.listviewlist2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // ListViewオブジェクト取得
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        // リストビューに表示するリストデータを作成
        var menuList = mutableListOf("唐揚げ定食", "ハンバーグ定食", "生姜焼き定食", "ステーキ定食", "野菜炒め定食", "とんかつ定食", "ミンチかつ定食",
            "コロッケ定食", "焼き魚定食", "焼肉定食")

        // アダプタオブジェクト作成
        /*
        * ArrayAdapterメソッド
        * 第一引数：コンテキスト
        * 第二引数：リストビューの各行のレイアウトを泡わすR値
        * 第三引数：リストデータ
        * */
        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, menuList)

        // リストビューにアダプタオブジェクトを設定
        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()


    }


    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            // 注文確認ダイアログフラグメントオブジェクト作成
            val dialogFragment = OrderConfirmDialogFragment()

            // ダイアログ表示
            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}
