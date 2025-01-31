import android.os.Parcel
import android.os.Parcelable

class Blog(
    val title: String?,
    val mainImage: Int,
    val date: String?,
    val text1: String?,
    val text2: String?,
    val text3: String?,
    val image1: Int,
    val image2: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(mainImage)
        parcel.writeString(date)
        parcel.writeString(text1)
        parcel.writeString(text2)
        parcel.writeString(text3)
        parcel.writeInt(image1)
        parcel.writeInt(image2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Blog> {
        override fun createFromParcel(parcel: Parcel): Blog {
            return Blog(parcel)
        }

        override fun newArray(size: Int): Array<Blog?> {
            return arrayOfNulls(size)
        }
    }
}