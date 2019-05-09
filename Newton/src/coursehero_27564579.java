import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to convert an XML RSS (version 2.0) feed from a given URL into the
 * corresponding HTML output file.
 *
 * @author Cavin Lauw
 *
 */
public final class RSSReader {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSReader() {
    }

    /**
     * Outputs the "opening" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * <html> <head> <title>the channel tag title as the page title </title>
     * </head> <body>
     * <h1>the page title inside a link to the <channel> link</h1>
     * <p>
     * the channel description
     * </p>
     * <table border="1">
     * <tr>
     * <th>Date</th>
     * <th>Source</th>
     * <th>News</th>
     * </tr>
     *
     * @param channel
     *            the channel element XMLTree
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the root of channel is a <channel> tag] and out.is_open
     * @ensures out.content = #out.content * [the HTML "opening" tags]
     */
    private static void outputHeader(XMLTree channel, SimpleWriter out) {
        assert channel != null : "Violation of: channel is not null";
        assert out != null : "Violation of: out is not null";
        assert channel.isTag() && channel.label().equals("channel") : ""
                + "Violation of: the label root of channel is a <channel> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        if (channel.isTag() && channel.label().equals("channel")
                && out.isOpen()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>");
            if (!(channel.child(getChildElement(channel, "title"))
                    .numberOfChildren() == 0)) {
                out.println(channel.child(getChildElement(channel, "title"))
                        .child(0).label());
            } else {
                out.println("The Title Unknown");
            }
            out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            if (!(channel.child(getChildElement(channel, "title"))
                    .numberOfChildren() == 0)) {
                out.println(" <h1><a href=\""
                        + channel.child(getChildElement(channel, "link"))
                                .child(0).label()
                        + "\">"
                        + channel.child(getChildElement(channel, "title"))
                                .child(0).label()
                        + "</a></h1>");
            } else {
                out.println(" <h1><a href=\""
                        + channel.child(getChildElement(channel, "link"))
                                .child(0).label()
                        + "\">The Title Unknown</a></h1>");
            }
            if (channel.child(getChildElement(channel, "description"))
                    .numberOfChildren() == 0) {
                out.println(" <p>No Description available</p>");
            } else {
                out.println(" <p>"
                        + channel.child(getChildElement(channel, "description"))
                                .child(0).label()
                        + "</p>");
            }
            out.println(" <table border=\"1\">");
            out.println(" <tr>");
            out.println("  <th>Date</th>");
            out.println("  <th>Source</th>");
            out.println("  <th>News</th>");
            out.println(" </tr>");
        }
    }

    /**
     * Outputs the "closing" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * </table>
     * </body> </html>
     *
     * @param out
     *            the output stream
     * @updates out.contents
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "closing" tags]
     */
    private static void outputFooter(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        if (out.isOpen()) {
            out.println(" </table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of type tag of the {@code XMLTree}
     *         or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of type tag of the {@code XMLTree} or
     *   -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";

        for (int i = 0; i < xml.numberOfChildren(); i++) {
            if (xml.child(i).label().equals(tag)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Processes one news item and outputs one table row. The row contains three
     * elements: the publication date, the source, and the title (or
     * description) of the item.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures <pre>
     * out.content = #out.content *
     *   [an HTML table row with publication date, source, and title of news item]
     * </pre>
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        if (item.isTag() && out.isOpen() && item.label().equals("item")) {
            out.println(" <tr>");
            if (!(getChildElement(item, "pubDate") == -1)
                    && !(item.child(getChildElement(item, "pubDate"))
                            .numberOfChildren() == 0)) {
                out.println(
                        "  <td>" + item.child(getChildElement(item, "pubDate"))
                                .child(0).label() + "</td>");
            } else {
                out.println("  <td>No Published Date Available</td>");
            }
            if (!(getChildElement(item, "source") == -1)) {
                if (!(item.child(getChildElement(item, "source"))
                        .numberOfChildren() == 0)) {
                    out.println("  <td><a href=\""
                            + item.child(getChildElement(item, "source"))
                                    .attributeValue("url")
                            + "\">"
                            + item.child(getChildElement(item, "source"))
                                    .child(0).label()
                            + "</td>");
                } else {
                    out.println("  <td><a href=\""
                            + item.child(getChildElement(item, "source"))
                                    .attributeValue("url")
                            + "\">No Source Name</td>");
                }

            } else {
                out.println("  <td>No Source Availbale</td>");
            }
            if (!(getChildElement(item, "link") == -1)
                    && !(item.child(getChildElement(item, "link"))
                            .numberOfChildren() == 0)) {
                if (!(getChildElement(item, "title") == -1)
                        && !(item.child(getChildElement(item, "title"))
                                .numberOfChildren() == 0)) {
                    out.println("  <td><a href=\""
                            + item.child(getChildElement(item, "link")).child(0)
                                    .label()
                            + "\">" + item.child(getChildElement(item, "title"))
                                    .child(0).label()
                            + "</a></td>");
                } else {
                    out.println("  <td><a href=\""
                            + item.child(getChildElement(item, "link")).child(0)
                                    .label()
                            + "\">"
                            + item.child(getChildElement(item, "description"))
                                    .child(0).label()
                            + "</a></td>");
                }

            } else {
                if (!(getChildElement(item, "title") == -1)
                        && !(item.child(getChildElement(item, "title"))
                                .numberOfChildren() == 0)) {
                    out.println("  <td>"
                            + item.child(getChildElement(item, "title"))
                                    .child(0).label()
                            + "</td>");
                } else {
                    out.println("  <td>"
                            + item.child(getChildElement(item, "description"))
                                    .child(0).label()
                            + "</td>");
                }

            }
            out.println(" </tr>");
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the URL of an RSS 2.0 news feed: ");
        String url = in.nextLine();
        String urlChecker = "^((https?|ftp)://|(www|ftp)\\.)?"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";
        if (url.matches(urlChecker)) {
            XMLTree xml = new XMLTree1(url);
            if (xml.isTag() && xml.label().equals("rss")
                    && xml.attributeNames().toString().contains("version")
                    && xml.attributeValue("version").equals("2.0")) {
                XMLTree channel = xml.child(0);
                out.print("Enter the file name that you want with the "
                        + "extension(.html): ");
                String fileName = in.nextLine();
                SimpleWriter outputFile = new SimpleWriter1L(fileName);
                outputHeader(channel, outputFile);
                int n = getChildElement(channel, "item");
                while (n < channel.numberOfChildren()) {
                    processItem(channel.child(n), outputFile);
                    n++;
                }
                outputFooter(outputFile);
                out.println("The program ended! (Please check the file under "
                        + "the directory of RSSReader. If you don't see "
                        + "the file try to refresh it.)");

                outputFile.close();
            } else {
                out.println("Not a valid RSS v2.0 feed!");
            }
        } else {
            out.println("Not a valid URL!");
        }

        in.close();

        out.close();
    }

}