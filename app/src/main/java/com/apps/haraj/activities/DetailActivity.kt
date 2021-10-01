package com.apps.haraj.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.apps.haraj.R


class DetailActivity : AppCompatActivity() {

    var detailTitle: TextView? = null
    var detailUsername: TextView? = null
    var detailCity: TextView? = null
    var detailDate: TextView? = null
    var detailBody: TextView? = null
    var detailImage: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        detailTitle = findViewById(R.id.detailTitle)
        detailUsername = findViewById(R.id.detailUsername)
        detailCity = findViewById(R.id.detailCity)
        detailDate =findViewById(R.id.detailDate)
        detailBody = findViewById(R.id.detailBody)
        detailImage = findViewById(R.id.detailImage)

        val i = intent
        val title = i.getStringExtra("title")
        val image = i.getStringExtra("image")
        val city = i.getStringExtra("city")
        val username = i.getStringExtra("username")
        val date = i.getStringExtra("date")
        val body = i.getStringExtra("body")

        detailTitle?.text=title
        detailCity?.text=city
        detailUsername?.text=username
        detailBody?.text=body
        detailDate?.text=date
        Picasso.get().load(image).into(detailImage)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id==android.R.id.home){
            finish()
            return true
        }
        if(id== R.id.share){
            val sendIntent: Intent=Intent().apply {
                action= Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,detailTitle?.text)
                type="text/plain"
            }
            val shareIntent=Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}