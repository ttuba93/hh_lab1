import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.hh.Job
import com.example.hh.R

class JobDetailsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_details)

        val job = intent.getParcelableExtra<Job>("job")

        val titleTextView: TextView = findViewById(R.id.jobTitle)
        val companyTextView: TextView = findViewById(R.id.jobCompany)
        val salaryTextView: TextView = findViewById(R.id.jobSalary)
        val locationTextView: TextView = findViewById(R.id.jobLocation)

        job?.let {
            titleTextView.text = it.title
            companyTextView.text = it.company
            salaryTextView.text = it.salary
            locationTextView.text = it.location
        }
    }
}
