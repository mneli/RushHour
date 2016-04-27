package g42861.rushhour.view;

/**
 * This class lets color a text. Example :
 * <table summary="colorOptions">
 * <tbody>
 * <tr><th>Color</th><th>Foreground</th><th>Background</th></tr>
 * <tr><td>Black</td>  <td>30</td> <td>40</td></tr>
 * <tr><td>Red</td> <td>31</td> <td>41</td></tr>
 * <tr><td>Green</td>  <td>32</td> <td>42</td></tr>
 * <tr><td>Yellow</td>  <td>33</td> <td>43</td></tr>
 * <tr><td>Blue</td>  <td>34</td> <td>44</td></tr>
 * <tr><td>Magenta</td>  <td>35</td> <td>45</td></tr>
 * <tr><td>Cyan</td>  <td>36</td> <td>46</td></tr>
 * <tr><td>White</td>  <td>37</td> <td>47</td></tr>
 * </tbody>
 * </table>
 *
 * @author G42861
 */
public class Color {

    /**
     * Default color of the BASH. Used to go back to the default bash color
     * after using one of coloring method below.
     *
     * @return the default color.
     */
    private static String toDefault() {
        return "\033[0m";
    }

    /**
     * Color a String to black
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toBlack(String str) {
        return "\033[30m" + str + toDefault();
    }

    /**
     * Color a String to cyan and it's background to red.
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toRed(String str) {
        return "\033[36;41m" + str + toDefault();
    }

    /**
     * Color a String to magenta and it's background to green.
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toGreen(String str) {
        return "\033[35;42m" + str + toDefault();
    }

    /**
     * Color a String to magenta and it's background to yellow.
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toYellow(String str) {
        return "\033[35;43m" + str + toDefault();
    }

    /**
     * Color a String to white and it's background to blue.
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toBlue(String str) {
        return "\033[37;44m" + str + toDefault();
    }

    /**
     * Color a String to white and it's background to magenta.
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toMagenta(String str) {
        return "\033[37;45m" + str + toDefault();
    }

    /**
     * Color a String to blue and it's background to cyan.
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toCyan(String str) {
        return "\033[34;46m" + str + toDefault();
    }

    /**
     * Color a String to blue and it's background to white.
     *
     * @param str the String to color.
     * @return the colored String.
     */
    public static String toWhite(String str) {
        return "\033[34;47m" + str + toDefault();
    }

}
