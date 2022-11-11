package com.example.lab_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_3.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    val flyData = listOf(
        Pair("Flora", "https://i.pinimg.com/564x/42/4b/fb/424bfb7228936292be3554e203c6ed79.jpg"),
        Pair("Tecna","https://i.pinimg.com/564x/a4/61/62/a461629960fe2c41379e5175b635f068.jpg"),
        Pair("Stella","https://i.pinimg.com/736x/98/7f/64/987f64a892cf888adc56b19a832ec43b.jpg"),
        Pair("Aisha", "https://i.pinimg.com/564x/92/f8/a6/92f8a6c168ff4436b0b808e38d109483.jpg"),
        Pair("Bloom", "https://i.pinimg.com/564x/77/b2/08/77b2083e1b5ea128b7b6bde144b99e22.jpg"),
        Pair("Musa", "https://i.pinimg.com/564x/7e/f2/57/7ef2572dfd223fd15c6071764eb8bf21.jpg")
    )

    val vinxData = listOf(
        Pair("Flora is the Guardian Fairy of Nature from Linphea and one of the founding members of the Winx Club and a former student of Alfea College for Fairies. She was the third Winx girl introduced, after Bloom and Stella. The team relies on her for potions and advice. She is in love with Helia.","https://i.pinimg.com/564x/37/a6/9d/37a69db82fc6861116dcb340488ff31f.jpg"),
        Pair("Tecna is the Fairy of Technology. She hails from Zenith and currently acts as its Guardian Fairy. Tecna is Timmy's girlfriend. She is one of the founding members of the Winx Club, being the fourth Winx girl introduced after Bloom, Stella and Flora, and is an alumna/student of the Alfea College for Fairies as of The Secret of the Lost Kingdom. Tecna is often relied on as the group's tactician and strategist thanks to her high IQ and ability to keep a cool, rational head even in times of high stress.","https://i.pinimg.com/564x/80/c6/66/80c666dc7a2e90ac286029b38fe40e6c.jpg"),
        Pair("Crown Princess Stella is the Fairy of the Sun and Moon, or the Fairy of the Shining Sun. She is a creative, skilled artist who is Brandon's fiancée. Stella is Solaria's Guardian Fairy, as well as the sole heiress to the Solarian Royal Throne, signified by her status as keeper of the royal family ring. She is one of the founding members of the Winx Club and is an almuna/student of the Alfea College for Fairies. Though immature and even selfish and bossy at times, Stella cares for her fellow Winx and sees herself responsible for them all as sort of a big sisterly figure.","https://i.pinimg.com/564x/a6/3f/77/a63f778bdeec267893fc6141694c34e6.jpg"),
        Pair("Crown Princess Aisha (Princess Layla in some versions) is the Fairy of Waves. She is the Crown Princess of Andros, as well as its Guardian Fairy. Aisha joins the Winx Club as its sixth member in the second season, and she is an alumna/student of the Alfea College for Fairies. Aisha is a self-confident and talented athlete who excels at dancing and swimming.","https://i.pinimg.com/564x/62/28/74/6228742f2f2337656493934bc688f0ca.jpg"),
        Pair("Princess Bloom is the Fairy of the Dragon Flame. She is Prince Sky's fiancée, the second princess of Domino and its Guardian Fairy. She is one of the founding members of the Winx Club, where she is recognized as the leader of their group, which also signifies her status as the central protagonist of the Winx Club series as a whole. She is also an alumna/student of the Alfea College for Fairies as of The Secret of the Lost Kingdom.","https://i.pinimg.com/564x/d0/6b/05/d06b05ae48aadabdb8c8ce34aa2dfc2d.jpg"),
        Pair("Musa is the Fairy of Music. She hails from Melody and currently acts as its Guardian Fairy. Musa is the daughter of Matlin and Ho-Boe, and is the girlfriend of Riven. She and her boyfriend, Riven, have a rocky and difficult but passionate relationship. Musa is a skilled singer and musician. She is one of the founding members of the Winx Club, being the fifth Winx girl introduced after Bloom, Stella, Flora and Tecna, and is an alumna/student of the Alfea College for Fairies","https://i.pinimg.com/564x/92/ea/70/92ea70dbeba6f65e3d9f415f1cf46682.jpg")

    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(MainActivity())

        val bundle = Bundle()

        val adapter = WinxAdapter(flyData){ position ->
            bundle.putString("InfoText", vinxData[position].first)
            bundle.putString("InfoPics", vinxData[position].second)
            findNavController().navigate(R.id.action_listFragment_to_infoFragment, bundle)
        }

        binding.recyclerView.adapter = adapter
    }

}