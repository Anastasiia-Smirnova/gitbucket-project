
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object datetimeago extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[java.util.Date,Boolean,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(latestUpdatedDate: java.util.Date,
  recentOnly: Boolean = true):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import gitbucket.core.view.helpers


Seq[Any](_display_(if(latestUpdatedDate != null)/*4.31*/{_display_(Seq[Any](format.raw/*4.32*/("""
  """),format.raw/*5.3*/("""<span data-toggle="tooltip" title=""""),_display_(/*5.39*/helpers/*5.46*/.datetime(latestUpdatedDate)),format.raw/*5.74*/("""">
    """),_display_(if(recentOnly)/*6.20*/{_display_(Seq[Any](format.raw/*6.21*/("""
      """),_display_(/*7.8*/helpers/*7.15*/.datetimeAgoRecentOnly(latestUpdatedDate)),format.raw/*7.56*/("""
    """)))}else/*8.12*/{_display_(Seq[Any](format.raw/*8.13*/("""
      """),_display_(/*9.8*/helpers/*9.15*/.datetimeAgo(latestUpdatedDate)),format.raw/*9.46*/("""
    """)))}),format.raw/*10.6*/("""
  """),format.raw/*11.3*/("""</span>
""")))} else {null} ),format.raw/*12.2*/("""
"""))
      }
    }
  }

  def render(latestUpdatedDate:java.util.Date,recentOnly:Boolean): play.twirl.api.HtmlFormat.Appendable = apply(latestUpdatedDate,recentOnly)

  def f:((java.util.Date,Boolean) => play.twirl.api.HtmlFormat.Appendable) = (latestUpdatedDate,recentOnly) => apply(latestUpdatedDate,recentOnly)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/datetimeago.scala.html
                  HASH: e083f418452173957e87dd52002d594b99429a96
                  MATRIX: 604->1|742->68|835->133|873->134|902->137|964->173|979->180|1027->208|1075->230|1113->231|1146->239|1161->246|1222->287|1250->299|1288->300|1321->308|1336->315|1387->346|1423->352|1453->355|1505->364
                  LINES: 14->1|18->3|21->4|21->4|22->5|22->5|22->5|22->5|23->6|23->6|24->7|24->7|24->7|25->8|25->8|26->9|26->9|26->9|27->10|28->11|29->12
                  -- GENERATED --
              */
          