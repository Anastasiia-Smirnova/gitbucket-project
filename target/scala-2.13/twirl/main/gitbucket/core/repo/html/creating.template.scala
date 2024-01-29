
package gitbucket.core.repo.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object creating extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(owner: String, repository: String)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/gitbucket/*2.11*/.core.html.main("Creating...")/*2.41*/ {_display_(Seq[Any](format.raw/*2.43*/("""
  """),format.raw/*3.3*/("""<div class="content-wrapper main-center">
    <div class="content body">
        <!-- Progress bar -->
      <div class="text-center" id="progress">
        <h2>Creating repository...</h2>
        <img src=""""),_display_(/*8.20*/context/*8.27*/.path),format.raw/*8.32*/("""/assets/common/images/indicator-bar.gif"/>
      </div>
        <!-- Error message -->
      <div id="error" style="display: none;">
        <h1>Failed to create repository</h1>
        <div id="errorMessage"></div>
      </div>
    </div>
  </div>
""")))}),format.raw/*17.2*/("""
"""),format.raw/*18.1*/("""<script>
  $(function () """),format.raw/*19.17*/("""{"""),format.raw/*19.18*/("""
    """),format.raw/*20.5*/("""checkCreating();
  """),format.raw/*21.3*/("""}"""),format.raw/*21.4*/(""");

  function checkCreating() """),format.raw/*23.28*/("""{"""),format.raw/*23.29*/("""
    """),format.raw/*24.5*/("""$.get('"""),_display_(/*24.13*/context/*24.20*/.path),format.raw/*24.25*/("""/"""),_display_(/*24.27*/owner),format.raw/*24.32*/("""/"""),_display_(/*24.34*/repository),format.raw/*24.44*/("""/creating', function (data) """),format.raw/*24.72*/("""{"""),format.raw/*24.73*/("""
      """),format.raw/*25.7*/("""if (data.creating == true) """),format.raw/*25.34*/("""{"""),format.raw/*25.35*/("""
        """),format.raw/*26.9*/("""setTimeout(checkCreating, 2000);
      """),format.raw/*27.7*/("""}"""),format.raw/*27.8*/(""" """),format.raw/*27.9*/("""else """),format.raw/*27.14*/("""{"""),format.raw/*27.15*/("""
        """),format.raw/*28.9*/("""if (data.error) """),format.raw/*28.25*/("""{"""),format.raw/*28.26*/("""
          """),format.raw/*29.11*/("""$('#errorMessage').text(data.error);
          $('#error').show();
          $('#progress').hide();
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/(""" """),format.raw/*32.11*/("""else """),format.raw/*32.16*/("""{"""),format.raw/*32.17*/("""
          """),format.raw/*33.11*/("""setTimeout(function()"""),format.raw/*33.32*/("""{"""),format.raw/*33.33*/(""" """),format.raw/*33.34*/("""location.href = '"""),_display_(/*33.52*/context/*33.59*/.path),format.raw/*33.64*/("""/"""),_display_(/*33.66*/owner),format.raw/*33.71*/("""/"""),_display_(/*33.73*/repository),format.raw/*33.83*/("""'; """),format.raw/*33.86*/("""}"""),format.raw/*33.87*/(""");
        """),format.raw/*34.9*/("""}"""),format.raw/*34.10*/("""
      """),format.raw/*35.7*/("""}"""),format.raw/*35.8*/("""
    """),format.raw/*36.5*/("""}"""),format.raw/*36.6*/(""");
  """),format.raw/*37.3*/("""}"""),format.raw/*37.4*/("""
"""),format.raw/*38.1*/("""</script>
"""))
      }
    }
  }

  def render(owner:String,repository:String,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(owner,repository)(context)

  def f:((String,String) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (owner,repository) => (context) => apply(owner,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/repo/creating.scala.html
                  HASH: bcf0bac2c885fa7c89f5654370bca0f70e69997f
                  MATRIX: 624->1|806->91|823->100|861->130|900->132|929->135|1163->343|1178->350|1203->355|1483->605|1511->606|1564->631|1593->632|1625->637|1671->656|1699->657|1758->688|1787->689|1819->694|1854->702|1870->709|1896->714|1925->716|1951->721|1980->723|2011->733|2067->761|2096->762|2130->769|2185->796|2214->797|2250->806|2316->845|2344->846|2372->847|2405->852|2434->853|2470->862|2514->878|2543->879|2582->890|2717->998|2746->999|2775->1000|2808->1005|2837->1006|2876->1017|2925->1038|2954->1039|2983->1040|3028->1058|3044->1065|3070->1070|3099->1072|3125->1077|3154->1079|3185->1089|3216->1092|3245->1093|3283->1104|3312->1105|3346->1112|3374->1113|3406->1118|3434->1119|3466->1124|3494->1125|3522->1126
                  LINES: 14->1|19->2|19->2|19->2|19->2|20->3|25->8|25->8|25->8|34->17|35->18|36->19|36->19|37->20|38->21|38->21|40->23|40->23|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|41->24|42->25|42->25|42->25|43->26|44->27|44->27|44->27|44->27|44->27|45->28|45->28|45->28|46->29|49->32|49->32|49->32|49->32|49->32|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|51->34|51->34|52->35|52->35|53->36|53->36|54->37|54->37|55->38
                  -- GENERATED --
              */
          