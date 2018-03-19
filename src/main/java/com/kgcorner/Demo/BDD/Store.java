package com.kgcorner.Demo.BDD;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kgcorner.Demo.BDD.Model.Book;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 3/15/2018.
 */
public class Store {
    private static List<Book> books;
    private static String booksJson = "[\n" +
            "   {\n" +
            "      \"name\":\"The Escape Artist\",\n" +
            "      \"detail\":\"Brad Meltzer\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/0c\\/e9\\/24\\/0ce924e0-6cf5-8ebf-0983-749f6229d2c9\\/9781455559510.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Woman Left Behind\",\n" +
            "      \"detail\":\"Linda Howard\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/d9\\/5d\\/70\\/d95d7025-927f-e912-4718-3d3881764980\\/9780062419033_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Red Sparrow\",\n" +
            "      \"detail\":\"Jason Matthews\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/44\\/a8\\/20\\/44a82033-6fc8-b58d-e2c7-ba3226e84b52\\/9781476706146.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Great Alone\",\n" +
            "      \"detail\":\"Kristin Hannah\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/86\\/c6\\/a5\\/86c6a595-c7eb-4fa3-5fca-0f3fb203a692\\/9781250165619.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Last Jedi: Expanded Edition (Star Wars)\",\n" +
            "      \"detail\":\"Jason Fry\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/68\\/b3\\/77\\/68b377ed-5fd4-3ea6-5ef3-97077d3075fe\\/9781524797126.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"A Wrinkle in Time\",\n" +
            "      \"detail\":\"Madeleine L'Engle\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication\\/83\\/ff\\/c0\\/mzi.nbsepjsw.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Cannery Row\",\n" +
            "      \"detail\":\"John Steinbeck\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication\\/29\\/cd\\/84\\/mzi.dhuhdmjg.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Wife Between Us\",\n" +
            "      \"detail\":\"Greer Hendricks & Sarah Pekkanen\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/aa\\/ce\\/46\\/aace46f9-1fec-3377-090f-8f05a04c08a5\\/9781250130938.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Weekends at Bellevue\",\n" +
            "      \"detail\":\"Julie Holland\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication4\\/v4\\/b9\\/47\\/1e\\/b9471e4e-fe6d-5437-9d37-bbda6f43bc1f\\/9780553906974.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Wedding\",\n" +
            "      \"detail\":\"Julie Garwood\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication20\\/v4\\/17\\/bd\\/cf\\/17bdcf48-7829-074a-a9ad-581726e3690d\\/9781101533550.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Little Fires Everywhere\",\n" +
            "      \"detail\":\"Celeste Ng\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/fa\\/b7\\/81\\/fab78127-ecf5-bc9e-47bc-986fbdbd91c8\\/9780735224308.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Woman in the Window\",\n" +
            "      \"detail\":\"A. J. Finn\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/17\\/87\\/9c\\/17879cc1-41c0-36eb-a5d9-8b32faef5c45\\/9780062678447_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Burn Bright\",\n" +
            "      \"detail\":\"Patricia Briggs\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/f4\\/7e\\/4d\\/f47e4db0-3fee-e024-ec86-0da1dcdf738d\\/9780698195837.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Marriage of Inconvenience\",\n" +
            "      \"detail\":\"Penny Reid\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/8d\\/88\\/95\\/8d889518-2788-3d2b-d9dc-9450c97a17b2\\/MOI_copy.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"High Voltage\",\n" +
            "      \"detail\":\"Karen Marie Moning\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/c6\\/a3\\/ec\\/c6a3eca1-7a45-e823-947b-497e9d80f363\\/9780399593673.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Gods Themselves\",\n" +
            "      \"detail\":\"Isaac Asimov\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication4\\/v4\\/7d\\/53\\/1b\\/7d531bc5-f5fb-b8f1-1309-87574a0b753b\\/9780307792389.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Fifty Fifty\",\n" +
            "      \"detail\":\"James Patterson & Candice Fox\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/38\\/e9\\/75\\/38e97517-53a5-c87d-46af-fb5ebb909582\\/9780316513241.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Baby Daddy\",\n" +
            "      \"detail\":\"Kendall Ryan\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/bc\\/6b\\/de\\/bc6bde53-9794-3733-1936-ea01d7c3cff7\\/BabyDaddy-iBooks.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"An American Marriage\",\n" +
            "      \"detail\":\"Tayari Jones\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/ae\\/c7\\/f8\\/aec7f88f-8b95-9b8e-60b0-53ab201e06d8\\/9781616207601.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Until Harmony\",\n" +
            "      \"detail\":\"Aurora Rose Reynolds\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/3b\\/f6\\/a8\\/3bf6a8a0-8289-3dd1-223a-f0610521376f\\/0000287616.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Look for Me\",\n" +
            "      \"detail\":\"Lisa Gardner\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication117\\/v4\\/45\\/8a\\/d8\\/458ad8e1-3588-29a3-eb48-e799190ff6a5\\/9781524742065.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Agent in Place\",\n" +
            "      \"detail\":\"Mark Greaney\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication127\\/v4\\/c8\\/0f\\/c4\\/c80fc469-28c8-3ef0-66da-c9ad99be1771\\/9780451488923.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Bachelor Nation\",\n" +
            "      \"detail\":\"Amy Kaufman\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/66\\/c2\\/b3\\/66c2b307-da32-afd5-3750-594305ba8a1a\\/9781101985922.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Restore Me\",\n" +
            "      \"detail\":\"Tahereh Mafi\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/f8\\/30\\/9a\\/f8309a25-171e-7d21-1c95-72e1d83b2bc6\\/9780062676382_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Walking Dead #177\",\n" +
            "      \"detail\":\"Robert Kirkman, Charlie Adlard, Cliff Rathburn & Stefano Gaudiano\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/63\\/20\\/eb\\/6320ebac-3249-0f3b-1e20-7ebd117cb38f\\/TheWalkingDead_177-1.png\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Still Me\",\n" +
            "      \"detail\":\"Jojo Moyes\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/b5\\/23\\/1e\\/b5231e04-6d2c-43f6-ced9-877bb65d537f\\/9780399562471.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Palace of Treason\",\n" +
            "      \"detail\":\"Jason Matthews\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/7c\\/0e\\/15\\/7c0e154d-1923-c29c-314a-378329a00eda\\/9781476793757.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Liam Devlin Novels\",\n" +
            "      \"detail\":\"Jack Higgins\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/78\\/06\\/dc\\/7806dc6e-9f9e-8786-87c0-322fd81454f0\\/9781504038812.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Darker\",\n" +
            "      \"detail\":\"E L James\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/6f\\/f1\\/a8\\/6ff1a812-b40e-5c31-b48f-bc435bbfbacc\\/9780385543989.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Subtle Art of Not Giving a F*ck\",\n" +
            "      \"detail\":\"Mark Manson\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/3c\\/b2\\/82\\/3cb282cf-e6f6-e1ed-9d4b-e6cb52594051\\/9780062457738_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Origin\",\n" +
            "      \"detail\":\"Dan Brown\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication127\\/v4\\/5f\\/a6\\/22\\/5fa622d7-dd47-51c7-9807-49ea518257e8\\/9780385542692.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"A Rogue of Her Own\",\n" +
            "      \"detail\":\"Grace Burrowes\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/ee\\/ec\\/c1\\/eeecc115-19b4-2b4e-ef69-4897776d8aef\\/9781538728925.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Hooked\",\n" +
            "      \"detail\":\"Christina Phillips\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/35\\/12\\/83\\/35128359-be59-8277-e04c-89439121d1a1\\/9781633758131.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Ready Player One\",\n" +
            "      \"detail\":\"Ernest Cline\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/50\\/4f\\/5f\\/504f5f99-40c9-84a3-fea8-c0b35e262612\\/9780307887450.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Night Moves\",\n" +
            "      \"detail\":\"Jonathan Kellerman\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication127\\/v4\\/dd\\/18\\/6b\\/dd186b7b-f96d-570d-c4fb-20e78fce3067\\/9780345541475.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"One Last Time\",\n" +
            "      \"detail\":\"Corinne Michaels\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/e1\\/d8\\/26\\/e1d82614-d1c0-ec4f-50d2-56a5c1184adc\\/OLT_FrontCover.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Taking the Heat\",\n" +
            "      \"detail\":\"Brenda Novak\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/8d\\/cc\\/09\\/8dcc09a0-edb6-09db-0929-cbbd5a06dade\\/9781488095900_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Boss Romance\",\n" +
            "      \"detail\":\"Victoria Quinn\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/f9\\/d8\\/15\\/f9d81577-af0c-09db-e70d-70ee5444bc91\\/0000276292.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Kremlin Conspiracy\",\n" +
            "      \"detail\":\"Joel C. Rosenberg\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/b7\\/72\\/7c\\/b7727ccb-7cee-716f-89dd-717e411c06f9\\/9781496427038.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Before We Were Yours\",\n" +
            "      \"detail\":\"Lisa Wingate\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/8b\\/d0\\/23\\/8bd023f0-b186-6af1-f59e-fe0923208709\\/9780425284698.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"When Jesus Wept\",\n" +
            "      \"detail\":\"Bodie and Brock Thoene\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication\\/v4\\/02\\/a0\\/c3\\/02a0c3bb-2ed6-40e7-ba65-ae3700d853ea\\/9780310335962.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Kremlin's Candidate\",\n" +
            "      \"detail\":\"Jason Matthews\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/1d\\/3b\\/40\\/1d3b40a9-df09-4552-038a-b2890c7efaf6\\/9781501140105.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Spider and the Fly\",\n" +
            "      \"detail\":\"Claudia Rowe\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication71\\/v4\\/74\\/71\\/12\\/7471128e-873a-18b2-dfe9-a254ae4ef4e2\\/9780062416148_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Educated\",\n" +
            "      \"detail\":\"Tara Westover\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication62\\/v4\\/b3\\/9d\\/fd\\/b39dfd5b-c13d-d781-76c3-3b2f72e6ce9e\\/9780399590511.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Shape of Water\",\n" +
            "      \"detail\":\"Guillermo del Toro & Daniel Kraus\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/71\\/64\\/e1\\/7164e161-9fb7-3c32-6b01-8db96432f5a3\\/9781250165374.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Spiritual Formation\",\n" +
            "      \"detail\":\"Henri J. M. Nouwen\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication1\\/v4\\/3d\\/f1\\/0c\\/3df10cdf-91ba-b69f-532d-52ffb413744e\\/cover.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Terminal List\",\n" +
            "      \"detail\":\"Jack Carr\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/e9\\/13\\/cb\\/e913cbbf-1627-d70a-8ec2-9b95aae745be\\/9781501180835.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Art of Social Media\",\n" +
            "      \"detail\":\"Guy Kawasaki & Peg Fitzpatrick\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication5\\/v4\\/02\\/6f\\/8a\\/026f8a2b-fbd6-2cda-0ab2-0cfa9ae0f4b4\\/9780698197671.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Rooster Bar\",\n" +
            "      \"detail\":\"John Grisham\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/4d\\/76\\/0b\\/4d760bec-07c9-c0a5-efab-aee4907d336e\\/9780385541183.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Possession\",\n" +
            "      \"detail\":\"Helen Hardt\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication111\\/v4\\/82\\/9a\\/10\\/829a100d-cc09-9c51-4d04-2fc29a1b1ce8\\/SC_3Possession_1800x2700.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Aviator's Wife\",\n" +
            "      \"detail\":\"Melanie Benjamin\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication4\\/v4\\/95\\/30\\/4a\\/95304a3c-8ebb-e232-0d09-75acf21be0bc\\/9780345534699.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Cascade:Unapologetic\",\n" +
            "      \"detail\":\"Pamela Ann\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/cf\\/00\\/96\\/cf009681-ef29-db2c-27a7-4dbc6e0a7803\\/Cascade-iBooks.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Bought the Farm\",\n" +
            "      \"detail\":\"Jeff Shelby\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication62\\/v4\\/88\\/74\\/e0\\/8874e038-c90a-96c6-3205-58a59e9321e5\\/0000246872.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Caroline\",\n" +
            "      \"detail\":\"Sarah Miller\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/20\\/c2\\/c2\\/20c2c29b-b142-7b65-1308-233e47603b9b\\/9780062685360_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"As You Wish\",\n" +
            "      \"detail\":\"Jude Deveraux\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/0a\\/99\\/5f\\/0a995f7e-5c7a-f59b-9eea-bf5aed09b855\\/9781488078651_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Obsession\",\n" +
            "      \"detail\":\"Helen Hardt\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/ee\\/f0\\/20\\/eef020c5-320b-76fd-5c5a-bcf2bee64e05\\/SC_2Obsession_1800x2700.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"If I Live\",\n" +
            "      \"detail\":\"Terri Blackstock\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication127\\/v4\\/f2\\/ba\\/61\\/f2ba6141-3ac8-9d3d-e5eb-d9f1d0998fea\\/9780310332572.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Unraveled\",\n" +
            "      \"detail\":\"Helen Hardt\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/18\\/7c\\/34\\/187c34b4-3326-f720-f16d-0317d3422052\\/SC_9Unraveled_1800x2700.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Brothers South of the Mason Dixon\",\n" +
            "      \"detail\":\"Abbi Glines\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/a3\\/ee\\/2a\\/a3ee2a07-37ff-53a3-b1d3-f7d080fa99c9\\/9780988301382.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Third Victim\",\n" +
            "      \"detail\":\"Phillip Margolin\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/12\\/96\\/d4\\/1296d487-c892-317b-bd1d-7ee9ba474928\\/9781250117519.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"A Gentleman in Moscow\",\n" +
            "      \"detail\":\"Amor Towles\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication49\\/v4\\/11\\/97\\/af\\/1197af02-bda2-a13a-3e5e-21fc87a9d3c0\\/9780399564048.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Hello Stranger\",\n" +
            "      \"detail\":\"Lisa Kleypas\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/be\\/7d\\/82\\/be7d8261-6286-a26a-d5cc-f17932a28c6e\\/9780062371898_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Sandman\",\n" +
            "      \"detail\":\"Lars Kepler\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/af\\/9a\\/0d\\/af9a0d2d-bcf3-d880-3381-3086b2d7b7a3\\/9781524732257.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Rock, the Road, and the Rabbi\",\n" +
            "      \"detail\":\"Kathie Lee Gifford\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/c9\\/1f\\/9c\\/c91f9c80-2069-5e55-26f5-0c0aed927302\\/9780785216001.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"White Knight\",\n" +
            "      \"detail\":\"CD Reiss\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/29\\/50\\/27\\/29502749-b205-e1b0-9492-155c42bfce61\\/white-knight-cover-FULL.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Ruin\",\n" +
            "      \"detail\":\"Samantha Towle\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/32\\/80\\/0f\\/32800fcc-4712-53d3-8b94-bae01f75d9b1\\/Ruin.Ebook-B_N.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Reflections of Yesterday\",\n" +
            "      \"detail\":\"Debbie Macomber\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/76\\/c2\\/17\\/76c21719-fbc0-a186-9d92-acbff066d609\\/9781941824078.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"12 Rules for Life\",\n" +
            "      \"detail\":\"Jordan B. Peterson\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/20\\/29\\/0d\\/20290d7d-dfc0-b9b5-05de-d4e46f5d3cba\\/9780345816047.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Chasing Harry Winston\",\n" +
            "      \"detail\":\"Lauren Weisberger\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/7e\\/e1\\/31\\/7ee13179-033d-c733-5ccf-4eb1cdcd56a7\\/9781416553182.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Dawn in Eclipse Bay\",\n" +
            "      \"detail\":\"Jayne Ann Krentz\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication\\/8e\\/0b\\/d2\\/mzi.chrfnbxg.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Fear University Series (Books 1-3 + Novella)\",\n" +
            "      \"detail\":\"Meg Collett\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/00\\/a9\\/64\\/00a96467-c9a5-e438-2a2a-1d3a33217ee6\\/9781370861194.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Fall from Grace\",\n" +
            "      \"detail\":\"Danielle Steel\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/60\\/43\\/d2\\/6043d2bc-ac02-d50f-951a-b9e9cb7f8052\\/9781101884010.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Twisted\",\n" +
            "      \"detail\":\"Helen Hardt\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/69\\/e6\\/df\\/69e6df94-2ba0-4bc5-3ee1-3e90be0a6724\\/SC_8Twisted_1800x2700.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"I'll Be Gone in the Dark\",\n" +
            "      \"detail\":\"Michelle McNamara\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/f3\\/ea\\/ec\\/f3eaec25-d24a-b9e0-c16e-a7db79b9d450\\/9780062319807_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Maytrees\",\n" +
            "      \"detail\":\"Annie Dillard\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication7\\/v4\\/7d\\/11\\/d8\\/7d11d8d1-52f1-611f-6a0d-c6132ea25604\\/cover.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Rebecca's Tale\",\n" +
            "      \"detail\":\"Sally Beauman\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication\\/33\\/e7\\/ba\\/mzi.lawgxxjt.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Imposter (The Bishop's Family Book #1)\",\n" +
            "      \"detail\":\"Suzanne Woods Fisher\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication71\\/v4\\/31\\/da\\/45\\/31da457c-e774-81c8-9c32-0e64890af541\\/9781441245427_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Dark in Death\",\n" +
            "      \"detail\":\"J. D. Robb\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/d4\\/f4\\/a5\\/d4f4a561-6e32-476a-42a8-7c9359d27432\\/9781250161550.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Boss Games\",\n" +
            "      \"detail\":\"Victoria Quinn\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication128\\/v4\\/71\\/00\\/8b\\/71008ba4-d4cb-f647-bf37-b9b3bf9f4cc3\\/0000276293.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Lake Silence\",\n" +
            "      \"detail\":\"Anne Bishop\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/d4\\/d9\\/ee\\/d4d9ee9c-ca49-a54f-6b72-403a4e32e104\\/9780399587252.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"You Are a Badass\",\n" +
            "      \"detail\":\"Jen Sincero\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication62\\/v4\\/94\\/7a\\/6e\\/947a6e8f-28c9-0b37-e89c-f16899dda9f7\\/9780762448319.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Every Patient Tells a Story\",\n" +
            "      \"detail\":\"Lisa Sanders\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication\\/de\\/54\\/c4\\/mzi.emkauohz.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Wrong Kind of Love (iBooks Edition)\",\n" +
            "      \"detail\":\"Lexi Ryan\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/4f\\/9f\\/39\\/4f9f392a-f936-3a75-5114-791ed37b5747\\/CVR-IB-WW-iBooks_Editions-wrong_kind_of_love.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Payback\",\n" +
            "      \"detail\":\"Kristin Harte\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/11\\/da\\/0d\\/11da0dbf-eb26-06cc-169a-22b29eb7df34\\/Payback-iBooks.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Grey\",\n" +
            "      \"detail\":\"E L James\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication1\\/v4\\/08\\/7d\\/b7\\/087db780-75d1-4347-947f-d571c84174d6\\/9781101946350.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Explosive Eighteen\",\n" +
            "      \"detail\":\"Janet Evanovich\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication3\\/v4\\/7f\\/43\\/d1\\/7f43d1cb-9a3a-5fa2-b1f8-0d32ac3cd100\\/9780345527721.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Shattered\",\n" +
            "      \"detail\":\"Helen Hardt\",\n" +
            "      \"link\":\"http:\\/\\/is5.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/dc\\/6a\\/57\\/dc6a57ea-6ff9-cf0a-cae4-3eedc9481704\\/SC_7Shattered_1800x2700.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Wife\",\n" +
            "      \"detail\":\"Alafair Burke\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication117\\/v4\\/7c\\/b9\\/4f\\/7cb94f76-179d-d1a9-f0f5-2857158c8316\\/9780062390530_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Sweet Dreams\",\n" +
            "      \"detail\":\"Kristen Ashley\",\n" +
            "      \"link\":\"http:\\/\\/is1.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/1e\\/eb\\/0b\\/1eeb0bea-7fa7-8c74-5756-df71d7d5b940\\/9781455599073.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Her Debt\",\n" +
            "      \"detail\":\"Rebel Rose\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/32\\/33\\/02\\/3233026b-443b-007e-04de-5ac7f1408e27\\/Her-Debt-iBooks.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Handmaid's Tale\",\n" +
            "      \"detail\":\"Margaret Atwood\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication111\\/v4\\/ac\\/4e\\/09\\/ac4e0934-5e0f-798f-cf45-a16a3ec606dd\\/9780547345666_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Surrender\",\n" +
            "      \"detail\":\"Helen Hardt\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication122\\/v4\\/01\\/79\\/3c\\/01793c13-f3ab-036b-d4f0-882b308b3558\\/SC_6Surrender_1800x2700.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The Master of Disguise\",\n" +
            "      \"detail\":\"Antonio J. Mendez\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication\\/v4\\/c5\\/83\\/cc\\/c583ccc7-a6d5-74b9-16a1-4842f92a7189\\/9780061865305_Outside_Front_Cover.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Erotic Stories for Punjabi Widows\",\n" +
            "      \"detail\":\"Balli Kaur Jaswal\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication127\\/v4\\/10\\/1b\\/6e\\/101b6e46-506f-96d8-2ff7-4c18f69fd2a5\\/9780062645135_marketingimage.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Harry Potter and the Sorcerer's Stone (Enhanced Edition)\",\n" +
            "      \"detail\":\"J.K. Rowling\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication6\\/v4\\/34\\/35\\/1f\\/34351f4b-3b31-375c-f414-4c586d0e27c1\\/US_Book_1_Cover.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"The 5 Love Languages\",\n" +
            "      \"detail\":\"Gary D. Chapman\",\n" +
            "      \"link\":\"http:\\/\\/is4.mzstatic.com\\/image\\/thumb\\/Publication3\\/v4\\/7c\\/13\\/07\\/7c130718-adac-4464-98ab-563e5ce5fa84\\/9780802492401.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Public Secrets\",\n" +
            "      \"detail\":\"Nora Roberts\",\n" +
            "      \"link\":\"http:\\/\\/is2.mzstatic.com\\/image\\/thumb\\/Publication\\/ee\\/68\\/3d\\/mzi.ulgsdanc.jpg\\/170x170bb-85.png\"\n" +
            "   },\n" +
            "   {\n" +
            "      \"name\":\"Reckless\",\n" +
            "      \"detail\":\"Lex Martin\",\n" +
            "      \"link\":\"http:\\/\\/is3.mzstatic.com\\/image\\/thumb\\/Publication118\\/v4\\/fa\\/39\\/61\\/fa396169-f428-4ed7-2762-3a8c43187bb2\\/Reckless_Ebook-SMALL.jpg\\/170x170bb-85.png\"\n" +
            "   }\n" +
            "]";
    public static void initializeLibrary() {
        Type listType = new TypeToken<List<Book>>() {}.getType();
        books = new Gson().fromJson(booksJson, listType);
        System.out.println("Book list size: "+books.size());
        Random randomPriceGenerator = new Random();
        for(Book book : books) {
            book.setPrice(randomPriceGenerator.nextInt(2000));
        }
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static  List<Book> getBooks(int numberofItems) {
        List<Book> items = new ArrayList<>();
        for (int i = 0; i < numberofItems; i++) {
            items.add(books.get(i));
        }
        return items;
    }

    public static List<Book> searchBook(String name) {
        List<Book> items = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getName().contains(name)) {
                items.add(books.get(i));
            }
        }
        return items;
    }

}
