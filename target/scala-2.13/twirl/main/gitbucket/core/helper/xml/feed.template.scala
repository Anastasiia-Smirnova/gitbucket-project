
package gitbucket.core.helper.xml

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object feed extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template2[List[gitbucket.core.model.Activity],gitbucket.core.controller.Context,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(activities: List[gitbucket.core.model.Activity])(implicit context: gitbucket.core.controller.Context):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import gitbucket.core.view.helpers


Seq[Any](format.raw/*1.104*/("""<?xml version="1.0" encoding="UTF-8"?>
"""),format.raw/*3.1*/("""<feed xmlns="http://www.w3.org/2005/Atom" xmlns:media="http://search.yahoo.com/mrss/" xml:lang="en-US">
  <id>tag:"""),_display_(/*4.12*/context/*4.19*/.host),format.raw/*4.24*/(""",2013:gitbucket</id>
  <title>GitBucket's activities</title>
  <link type="application/atom+xml" rel="self" href=""""),_display_(/*6.55*/context/*6.62*/.baseUrl),format.raw/*6.70*/("""/activities.atom"/>
  <author>
    <name>GitBucket</name>
    <uri>"""),_display_(/*9.11*/context/*9.18*/.baseUrl),format.raw/*9.26*/("""</uri>
  </author>
  <updated>"""),_display_(/*11.13*/helpers/*11.20*/.datetimeRFC3339(if(activities.isEmpty) new java.util.Date else activities.map(_.activityDate).max)),format.raw/*11.119*/("""</updated>
  """),_display_(/*12.4*/activities/*12.14*/.map/*12.18*/ { activity =>_display_(Seq[Any](format.raw/*12.32*/("""
  """),format.raw/*13.3*/("""<entry>
    <id>tag:"""),_display_(/*14.14*/context/*14.21*/.host),format.raw/*14.26*/(""","""),_display_(/*14.28*/helpers/*14.35*/.date(activity.activityDate)),format.raw/*14.63*/(""":activity:"""),_display_(/*14.74*/activity/*14.82*/.activityId),format.raw/*14.93*/("""</id>
    <published>"""),_display_(/*15.17*/helpers/*15.24*/.datetimeRFC3339(activity.activityDate)),format.raw/*15.63*/("""</published>
    <updated>"""),_display_(/*16.15*/helpers/*16.22*/.datetimeRFC3339(activity.activityDate)),format.raw/*16.61*/("""</updated>
    <link type="text/html" rel="alternate" href=""""),_display_(/*17.51*/context/*17.58*/.baseUrl),format.raw/*17.66*/("""/"""),_display_(/*17.68*/activity/*17.76*/.userName),format.raw/*17.85*/("""/"""),_display_(/*17.87*/activity/*17.95*/.repositoryName),format.raw/*17.110*/("""" />
    <title type="html">"""),_display_(/*18.25*/helpers/*18.32*/.removeHtml(helpers.activityMessage(activity.message))),format.raw/*18.86*/("""</title>
    <author>
      <name>"""),_display_(/*20.14*/activity/*20.22*/.activityUserName),format.raw/*20.39*/("""</name>
      <uri>"""),_display_(/*21.13*/helpers/*21.20*/.url(activity.activityUserName)),format.raw/*21.51*/("""</uri>
    </author>
    <content type="html">"""),_display_(/*23.27*/helpers/*23.34*/.activityMessage(activity.message)),format.raw/*23.68*/("""</content>
  </entry>
  """)))}),format.raw/*25.4*/("""
"""),format.raw/*26.1*/("""</feed>
"""))
      }
    }
  }

  def render(activities:List[gitbucket.core.model.Activity],context:gitbucket.core.controller.Context): play.twirl.api.XmlFormat.Appendable = apply(activities)(context)

  def f:((List[gitbucket.core.model.Activity]) => (gitbucket.core.controller.Context) => play.twirl.api.XmlFormat.Appendable) = (activities) => (context) => apply(activities)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/feed.scala.xml
                  HASH: 53efde618c594e62f984718293a41a8437968823
                  MATRIX: 639->1|813->143|878->103|943->178|1084->293|1099->300|1124->305|1265->420|1280->427|1308->435|1402->503|1417->510|1445->518|1503->549|1519->556|1640->655|1680->669|1699->679|1712->683|1764->697|1794->700|1842->721|1858->728|1884->733|1913->735|1929->742|1978->770|2016->781|2033->789|2065->800|2114->822|2130->829|2190->868|2244->895|2260->902|2320->941|2408->1002|2424->1009|2453->1017|2482->1019|2499->1027|2529->1036|2558->1038|2575->1046|2612->1061|2668->1090|2684->1097|2759->1151|2821->1186|2838->1194|2876->1211|2923->1231|2939->1238|2991->1269|3065->1316|3081->1323|3136->1357|3191->1382|3219->1383
                  LINES: 14->1|17->2|20->1|21->3|22->4|22->4|22->4|24->6|24->6|24->6|27->9|27->9|27->9|29->11|29->11|29->11|30->12|30->12|30->12|30->12|31->13|32->14|32->14|32->14|32->14|32->14|32->14|32->14|32->14|32->14|33->15|33->15|33->15|34->16|34->16|34->16|35->17|35->17|35->17|35->17|35->17|35->17|35->17|35->17|35->17|36->18|36->18|36->18|38->20|38->20|38->20|39->21|39->21|39->21|41->23|41->23|41->23|43->25|44->26
                  -- GENERATED --
              */
          