package com.onk.group3;

import com.onk.group3.models.*;
import com.onk.group3.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class OnkProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnkProductServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner initializeDb(
            ProductRepository productRepository
    ) {
        return (args) -> {
            productRepository.deleteAll();

            initPalms(productRepository);
            initWaterPlants(productRepository);
            initShrubs(productRepository);
        };
    }

    /**
     * Initialize database with palm trees.
     * Data gathered from: http://realpalmtrees.com/palm-tree-store/large-palm-trees
     * @param repository The repository.
     */
    private void initPalms(ProductRepository repository) {
        ArrayList palms = new ArrayList();
        palms.add(new Long(1));

        long id = 1;
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                5295.0,
                "Bamboo Palm Tree",
                "The Large Bamboo Palm (Chamaedorea seifrizii) originates from Southeast Asia, but can now be found abundantly throughout Central America. The Bamboo Palm goes by many other common names such as Bamboo Palm, Reed Palm, Clustered Parlor Palm, and Cane Palm. It has a deep green color to the stalk and thin to thick-feathery leaves. With the proper amount of water the Bamboo Palm can grow rapidly to an average height of 10 to 15 feet. There are many species belonging to the Chamaedorea family but by far the Chamaedorea seifrizii is the most seen. When situated in the right environment the Bamboo Palm can flourish and bring good luck and fortune to your home or office.",
                null,
                palms,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                2645.0,
                "Banana Tree",
                "This beautiful exotic looking palm tree will make a garden come to life. Its natural tropical beauty will add a tropical touch to any setting.",
                null,
                palms,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                5299.0,
                "Bird of Paradise",
                "The beautiful Bird of Paradise is known throughout the world for its vibrant-colored flowers and seedlings. The Bird of Paradise typically grows in clumps and produces small plants around its root base, known as pups or sucklings. this tropical palm tree can truly make your garden pop with color. The Bird of Paradise really brings in the sense of the tropics to any area.",
                null,
                palms,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                5995.0,
                "Bismarck Palm Tree",
                "Hailing from the Madagascar Islands is the massive and Jurassic Bismarck Palm Tree (Bismarckia nobilis). A palm tree that will grasp your attention at a moment’s sight. The Bismarck palm will gain your respect as it gracefully lines many grand hotels and many sub-developments in the south. Widely used for xeriscaping in southern California to Arizona all the way to Florida, the Bismarck will make a great impression and addition to any home. The Bismarck when fully matured can be a beautiful focal point to your yard or garden. The Bismarck Palm Tree also does well indoors, but due to its massive size, usually finds its ultimate home outdoors. It can grow to the maximum average height of about 60 ft but with plenty of time. This palm tree is considered cold hardy to about 20 degrees F. More mature Bismarck Palm trees can with stand lower temperatures that of 20 degrees F. Each Bismarck has noticeable differences, from its small spots found on its stems to the different shades of green, silver, and bluish colors. The silver-blue leaves can make a dramatic appearance to any pool area, lawn, or backyard. The Bismarck palm tree is the most sought after outdoor palm for its beauty an awe striking appearance.",
                null,
                palms,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                5795.0,
                "Bottle Palm Tree",
                "The Bottle Palm (Hyophorbe lagenicaulis) is known for its very unique one of a kind large swollen trunk. The striking Large Bottle Palm tree is from the Mascarene Islands, which are in the Indian Ocean just East of Madagascar. The Bottle Palm is nearly extinct in its natural habitat but is now widely commercially grown for its ornamental use. The Bottle Palm is very slow growing and adds flavor with uniqueness to any setting. The most distinguishing feature of the Bottle Palm is the bulged section of its trunk. This bulged section changes in colors throughout its life from gray, green, and even purple. The unique palm tree grows to the maximum average height of nearly 20 feet tall when mature but will take many years to do so. It has Pinnate (feather shaped), arched leaves that will give any location a true feeling of the tropics. The Bottle Palm Tree enjoys full sun and does best with sandy, good draining soil. The Bottle Palm is not cold hardy and will not tolerate frost. The Bottle Palm is usually the center of attention and a conversation starter in any garden or home. \n" +
                        "This palm tree will make a great addition to any home office or landscape. It will give a sense of the tropics with little cost. Its time to go green and buy real palm trees. Palm trees are also great for indoors because they act as a natural humidifier and detoxifier by removing Carbon Monoxide and replacing the air with fresh Oxygen. Real Palm Trees make a home feel like home by giving you the feel of nature inside or out. Buy this palm tree and have a piece of unspoiled nature. ",
                null,
                palms,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                2099.0,
                "Cabbage Palm Tree",
                "The official State Tree for Florida and South Carolina is the Cabbage Palm Tree (Sabal Palmetto) and for good reasons. The settlers lived off the heart of the cabbage palm and even made it into a famous stew that can still be found in rural areas of Florida. The Cabbage palm gave settlers and visitors and instant nutrition source during times of need or travel. It is one of many of the cold hardy palm trees belonging to the genus Sabal. Some include: Sabal bermudana, Sabal causiarum, Sabal etonia, Sabal mexicana, Sabal minor, Sabal miamiensis and Sabal Palmetto. The cold hardy Cabbage Palm tree is widely used for landscaping all through out Florida and other southern states, including; Georgia, South Carolina, North Carolina, Texas, Arizona, and California. The highly tolerant Cabbage Palm tree makes for a great palm, due to its durability and its drought tolerance. The Cabbage Palm has gain popularity because it is very durable and will tolerate a wide variety of soil and weather conditions. Whether it be standing water, high winds, salt water, or salt water winds. The Cabbage Palm will thrive in any condition. This palm tree will not only enhance the look of any commercial or residential area, but will also create a tropical feel to any environment. The beautiful round shaped crown of the Cabbage Palm will stand out and will serve for multiple uses for outdoor applications. The Cabbage Palms is very much maintenance free.",
                null,
                palms,
                null,
                null));
    }

    /**
     * Initialize database with water plants.
     * Data gathered from: http://www.thewatergardenshop.com/water-plants.html
     * @param repository The repository.
     */
    private void initWaterPlants(ProductRepository repository) {
        ArrayList waterPlants = new ArrayList();
        waterPlants.add(new Long(2));
        long id = 7;

        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                39.0,
                "Green Acorus",
                "Grassy-leaved species grows in fans from the growing tips of the creeping rhizome.  Some fans also grow along the rhizome with lateral branching occurring,  but primary growth is in the tip.  Grows 8 - 12 inches tall. ",
                null,
                waterPlants,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                19.0,
                "Frogbit",
                "Free floating small plant which resembles a miniature water lily.  It has nickel sized, kidney shaped, green shiny leaves about 1 in. across that grow in rosettes on the water.  New rosettes arise from the plants to produce new growth.  An inconspicuous white flower with a yellow center may be tucked among the leaves. The undersides of the leaves are puffed with spongy, air-holding tissue, helping in the floating quality.  Again winterizing is only possible indoors in an aquarium.",
                null,
                waterPlants,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                24.0,
                "Water Hyacinth",
                "Delicate flowers that usually last only a day, grace this plant with bluish to lilac blooms marked with yellow peacock center eyes on 6 in. spikes at the center of a rosette of glossy green, bulbous leaves.  Air pockets in the bulbous areas keep the plant afloat.  Long thick black roots trail to provide spawning and hiding places for fish.  Another benefit is the nutrient absorbing qualities of the plant.  Good for placement in the pond early as possible to get ahead of the algae.  Typical to tropicals it requires heat and sunlight to flourish and bloom.  A vigorous reproducer, you will need to thin out older plants. Will not winter over in most climates unless brought indoors to ample light and warm water above 70 degrees.",
                null,
                waterPlants,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                24.0,
                "Water Lettuce",
                "Tropical, free floating plant.  Velvety ribbed leaves form delicate, pale green rosettes.  Resembles a cabbage plant. The leaves grows 8 - 10 in. long and 4 in. wide and produce plantlets that stretch out from the mother plant on slender stems.  These can be separated and the older plants can be thinned out. If yellowing occurs the plants can be separated from the pond and fertilized.   Excellent in shady ponds.",
                null,
                waterPlants,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                23.0,
                "Hornwort",
                "Free floating plant with whorls of delicate forked leaves on slender stems. Can grow 12 - 24 in long. Will propagate through breaking of the stem. Simply place the plant in the pond to float freely and to offer shade, shelter, and spawning media for fish. Excellent oxygenator. Drops to pond bottom in winter.",
                null,
                waterPlants,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                39.0,
                "Caltha palustris",
                "Nearly round leaves are heart shaped and have dentate margins.  Waxy yellow buttercup like flowers are produced in early spring.  Usually grows 1 - 1.5 ft. in shallow water up to 4 - 5 in. deep or in soggy  soil around the pond or stream. Is notorious for going dormant during the summer when placed in full sun in hot summers. When in shady area or shaded by other plants as they grow it will flourish.",
                null,
                waterPlants,
                null,
                null));
    }

    /**
     * Initialize database with shrubs.
     * Data gathered from: http://www.naturehills.com/bushes-and-shrubs
     * @param repository The repository.
     */
    private void initShrubs(ProductRepository repository) {
        ArrayList shrubs = new ArrayList();
        shrubs.add(new Long(3));
        long id = 13;

        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                669.0,
                "Adams Needle",
                "The Adams Needle Yucca, Yucca filamentosa, has stiff evergreen rosettes and are part of the native flora in hot dry Central and North American scrublands.\n" +
                        "\n" +
                        "Adams Needle Yuccas are hardier than they appear.  They are heat, cold, drought tolerant and diesase and insect resistant. They only fail in cold wet exposed inland positions where they are better grown as container plants.\n" +
                        "\n" +
                        "Otherwise, they are handsome architectural foliage plants for dry, sunny borders. The mound of lance like leaves will mature to 2'-4' with a spread of 3'-5'.\n" +
                        "\n" +
                        "This variety has a white edge on the stiff green lancelike leaves. The leaves stay green throughout the winter.\n" +
                        "\n" +
                        "Yucca filamentosa makes dense clumps of stiff leaves 30 inches or so long and edged with fine curly hairs.\n" +
                        "\n" +
                        "The remarkable 6' spikes of white tulip shaped flowers in late June last for more than an month. Butterflies and hummingbirds love them. The flower spikes do not appear until the plants are five years old.\n" +
                        "\n" +
                        " Yuccas may live for 60 or more years. They do not transplant well and have a very deep taproot, but are a carefree perennial that will bloom for years.",
                null,
                shrubs,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                449.0,
                "American Holly",
                "The American Holly (Ilex opaca) also called the White Holly or Christmas Holly, is the most familiar holly.  It is a small tree or shrub with striking evergreen foliage that's perfect for a privacy hedge.\n" +
                        "\n" +
                        "The American Holly is easy to identify. It has thick, smooth, dark green, spiny leaves that are a yellowish green underneath. Unlike some hollies, the American Holly keeps its foliage from top to bottom for the life of the tree. It can easily reach a height of 50' with a 35' spread.\n" +
                        "\n" +
                        "Great for a privacy hedge and noise barrier, but its natural pyramidal shape also makes it a perfect ornamental tree for any yard for full sun to part shade.\n" +
                        "\n" +
                        "Because it does well in shade it is also a wonderful choice as an understory tree. This means if you’d like to fill in gaps between larger trees in your yard the American Holly can be planted under them.\n" +
                        "\n" +
                        "The flowers of the American Holly appear from April to June. Bundles of small white flowers are a beautiful contrast to the deep shiny foliage.  They are a delicate reminder in spring of the berries that will follow.\n" +
                        "\n" +
                        "The berries grow on your holly from September to November. The berries start out green, and then mature to a brilliant red. The American Holly will keep its dazzling display of deep red berries against emerald foliage through the winter. \n" +
                        "\n" +
                        "You will love having fresh holly branches to decorate your house during the winter months, but you will also be doing a great service for the small animals and birds in your neighborhood. During the winter the American Holly is an important source of food for the birds, and provides a safe haven for shelter and nests in its thick foliage.\n" +
                        "\n" +
                        "The American Holly needs minimal watering and can grow in nearly any soil including hard clay. You will enjoy its dense green foliage all year.",
                null,
                shrubs,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                795.0,
                "Autumn Amethyst™ Encore® Azalea",
                "Autumn Amethyst Encore Azalea, Azalea x 'Conlee', has brilliant flowers and a repeating bloom nature. Plant a few of these in your mixed border or use as a foundation planting. These would also look terrific in containers on your front porch or patio.\n" +
                        "\n" +
                        "Your Autumn Amethyst Encore Azalea explodes in spring with 2-inch, single blooms of brilliant, hot-pink intensity. The blossoms smother the branches in a veritable blanket of color!\n" +
                        "\n" +
                        "The vibrant shades of pink continue throughout the summer and into fall. Just when you think the colorful display is over, your Autumn Amethyst Encore Azalea will prove itself true to its name when its dark evergreen foliage transforms into purple hues for winter.\n" +
                        "\n" +
                        "Autumn Amethyst Encore Azalea will grow up to 4 feet in height with an equal spread. The Azalea x 'Conlee' PP#10580 is an easy-care Azalea that is the most cold hardy of the Encore series. You can leave Autumn Amethyst to grow naturally, but a gentle pruning will enhance its bloom. It’s mildew, heat and disease resistant, as well as adaptable to a variety of conditions.\n" +
                        "\n" +
                        "Azaleas are well known for their stunning welcome to spring. Autumn Amethyst accomplishes not only a brilliant spring display but carries it over into fall, and keeps right on going into the winter months. You’ll love the beauty this remarkable Azalea brings to your yard this year!",
                null,
                shrubs,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                795.0,
                "Autumn Royalty™ Encore® Azalea\n",
                "Autumn Royalty Encore Azalea, Azalea x 'Conlec', is known for its repeating blooms and sun tolerance. These would make an excellent, low-growing hedge along your property line or plant one in a side yard for some added color, spring through fall.\n" +
                        "\n" +
                        "Imagine a blanket of funnel-shaped, 4-inch blooms covering your Azalea shrub in pink-hued, purple splendor each and every spring. Now consider that this Azalea doesn’t just put on that show once a year (as most Azaleas do), but continues it right into fall. That’s your Autumn Royalty Encore Azalea!\n" +
                        "\n" +
                        "Autumn Royalty Encore Azalea will burst into floral perfection in spring, and provide you with an “encore” of that performance until winter rears its chilly head. Even when the show is over, your Autumn Royalty will continue to provide a lively presence in your yard with its 6-inch oval, evergreen foliage.\n" +
                        "\n" +
                        "Autumn Royalty will grow up to 5 feet with a 4 foot spread. It has an upright habit with a compact nature. Autumn Royalty grows naturally beautiful, but will accept some pruning if you so desire.\n" +
                        "\n" +
                        "It not only provides an abundance of blooms, but does so with little or no care from you. You can just plant it and sit back to watch the show!\n" +
                        "\n" +
                        "Autumn Royalty Encore Azalea won “Rhododendron of the Year” by the Rhododendron Society of America and once you plant one you’ll understand why! ",
                null,
                shrubs,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                398.0,
                "Bayberry",
                "Bayberry, also known as Southern Wax Myrtle, is often used as a mass planting item. Bayberry also creates attractive hedges, thickets, and privacy borders, but it may also be successfully integrated as a focal point planting.\n" +
                        "\n" +
                        "Bayberry is extremely tolerant of sandy soil and even high salt content.  Bayberry has long been used as a candle-making ingredient as the drupes carry a coating appropriate for making wax. \n" +
                        "\n" +
                        "Deer resistant, Bayberry leaves offer a pleasant fragrance throughout the spring and summer, and this fragrance makes them useful, too, as natural insect repellant. \n" +
                        "\n" +
                        "Including Bayberry in your garden scheme ensures safe harbor for a variety of desirable creatures from birds to butterflies.  Order  yours today to create attractive wildlife habitats. ",
                null,
                shrubs,
                null,
                null));
        repository.save(new Product(
                id++,
                ProductStatus.InStock,
                595.0,
                "Blue Chip Juniper",
                "Juniper - Blue Chip, Juniperus horizontalis 'Blue Chip', is a prostrate cultivar that features steel-blue foliage throughout the year with purplish tips in winter. It typically grows up to 8\" to 10” tall but spreads to 10’ wide. It forms a low ground cover that generally spreads by long trailing branches with abundant short branchlets.\n" +
                        "\n" +
                        "Foliage is typically green to blue-green during the growing season, but often acquires purple tones in winter. It grows in average, medium moisture, well-drained soils in full sun. Blue Chip adapts to a wide range of soils, but prefers a dryish, sandy soil. It tolerates hot, relatively dry growing conditions, somewhat poor soils and many city air pollutants. Intolerant of wet soils.",
                null,
                shrubs,
                null,
                null));
    }
}
