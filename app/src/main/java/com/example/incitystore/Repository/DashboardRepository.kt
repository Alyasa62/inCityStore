import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.incitystore.Domain.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.jvm.java

class DashboardRepository {

    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseReference = firebaseDatabase.getReference("Categories")

    fun loadCategories(): LiveData<MutableList<CategoryModel>> {

        val mutableLiveData = MutableLiveData<MutableList<CategoryModel>?>()
        val ref = firebaseDatabase.getReference("Categories")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val categories = mutableListOf<CategoryModel>()
                for (categorySnapshot in snapshot.children) {
                    val category = categorySnapshot.getValue(CategoryModel::class.java)
                    category?.let { categories.add(it) }
                }
                mutableLiveData.value = categories
            }

            override fun onCancelled(error: DatabaseError) {
                mutableLiveData.value = null
            }
        })



        return mutableLiveData as LiveData<MutableList<CategoryModel>>
    }
}