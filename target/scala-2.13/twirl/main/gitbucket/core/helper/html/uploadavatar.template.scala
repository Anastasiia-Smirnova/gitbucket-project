
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object uploadavatar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Option[gitbucket.core.model.Account],gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(account: Option[gitbucket.core.model.Account])(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div id="avatar" class="muted">
  """),_display_(if(account.nonEmpty && account.get.image.nonEmpty)/*3.54*/{_display_(Seq[Any](format.raw/*3.55*/("""
    """),format.raw/*4.5*/("""<img src=""""),_display_(/*4.16*/context/*4.23*/.path),format.raw/*4.28*/("""/"""),_display_(/*4.30*/account/*4.37*/.get.userName),format.raw/*4.50*/("""/_avatar" style="width: 120px; height: 120px;"/>
  """)))}else/*5.10*/{_display_(Seq[Any](format.raw/*5.11*/("""
    """),format.raw/*6.5*/("""<div id="clickable">Upload Image</div>
  """)))}),format.raw/*7.4*/("""
"""),format.raw/*8.1*/("""</div>
"""),_display_(if(account.nonEmpty && account.get.image.nonEmpty)/*9.52*/{_display_(Seq[Any](format.raw/*9.53*/("""
  """),format.raw/*10.3*/("""<label>
    <input type="checkbox" name="clearImage"/> Clear image
  </label>
""")))} else {null} ),format.raw/*13.2*/("""
"""),format.raw/*14.1*/("""<input type="hidden" name="fileId" value=""/>
"""),_display_(if(account.isEmpty || account.get.image.isEmpty)/*15.50*/{_display_(Seq[Any](format.raw/*15.51*/("""
"""),format.raw/*16.1*/("""<script>
$(function()"""),format.raw/*17.13*/("""{"""),format.raw/*17.14*/("""
  """),format.raw/*18.3*/("""var dropzone = new Dropzone('div#clickable', """),format.raw/*18.48*/("""{"""),format.raw/*18.49*/("""
    """),format.raw/*19.5*/("""url: '"""),_display_(/*19.12*/context/*19.19*/.path),format.raw/*19.24*/("""/upload/image',
    previewsContainer: 'div#avatar',
    parallelUploads: 1,
    thumbnailWidth: 120,
    thumbnailHeight: 120
  """),format.raw/*24.3*/("""}"""),format.raw/*24.4*/(""");

  dropzone.on("success", function(file, id)"""),format.raw/*26.44*/("""{"""),format.raw/*26.45*/("""
    """),format.raw/*27.5*/("""$('div#clickable').remove();
    $('input[name=fileId]').val(id);
  """),format.raw/*29.3*/("""}"""),format.raw/*29.4*/(""");
"""),format.raw/*30.1*/("""}"""),format.raw/*30.2*/(""");
</script>
""")))} else {null} ),format.raw/*32.2*/("""
"""),format.raw/*33.1*/("""<style type="text/css">
div.dz-filename, div.dz-size, div.dz-progress, div.dz-success-mark, div.dz-error-mark, div.dz-error-message """),format.raw/*34.109*/("""{"""),format.raw/*34.110*/("""
  """),format.raw/*35.3*/("""display: none;
"""),format.raw/*36.1*/("""}"""),format.raw/*36.2*/("""

"""),format.raw/*38.1*/("""div#clickable """),format.raw/*38.15*/("""{"""),format.raw/*38.16*/("""
  """),format.raw/*39.3*/("""width: 100%;
  text-align: center;
  line-height: 120px;
"""),format.raw/*42.1*/("""}"""),format.raw/*42.2*/("""

"""),format.raw/*44.1*/("""div.dz-message, div.dz-fallback """),format.raw/*44.33*/("""{"""),format.raw/*44.34*/("""
  """),format.raw/*45.3*/("""width: 240px;
  color: #000000;
  font-size: 12px;
  line-height: 14px;
"""),format.raw/*49.1*/("""}"""),format.raw/*49.2*/("""

"""),format.raw/*51.1*/("""div#avatar """),format.raw/*51.12*/("""{"""),format.raw/*51.13*/("""
  """),format.raw/*52.3*/("""background-color: #f8f8f8;
  border: 1px dashed silver;
  width: 120px;
  height: 120px;
"""),format.raw/*56.1*/("""}"""),format.raw/*56.2*/("""
"""),format.raw/*57.1*/("""</style>"""))
      }
    }
  }

  def render(account:Option[gitbucket.core.model.Account],context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(account)(context)

  def f:((Option[gitbucket.core.model.Account]) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (account) => (context) => apply(account)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/uploadavatar.scala.html
                  HASH: c4c7c4e15c22cd1bf532d99e9c40140b08501fa8
                  MATRIX: 653->1|847->102|958->187|996->188|1027->193|1064->204|1079->211|1104->216|1132->218|1147->225|1180->238|1254->296|1292->297|1323->302|1394->344|1421->345|1505->403|1543->404|1573->407|1695->486|1723->487|1845->582|1884->583|1912->584|1961->605|1990->606|2020->609|2093->654|2122->655|2154->660|2188->667|2204->674|2230->679|2386->808|2414->809|2489->856|2518->857|2550->862|2645->930|2673->931|2703->934|2731->935|2788->949|2816->950|2977->1082|3007->1083|3037->1086|3079->1101|3107->1102|3136->1104|3178->1118|3207->1119|3237->1122|3321->1179|3349->1180|3378->1182|3438->1214|3467->1215|3497->1218|3596->1290|3624->1291|3653->1293|3692->1304|3721->1305|3751->1308|3867->1397|3895->1398|3923->1399
                  LINES: 14->1|19->2|20->3|20->3|21->4|21->4|21->4|21->4|21->4|21->4|21->4|22->5|22->5|23->6|24->7|25->8|26->9|26->9|27->10|30->13|31->14|32->15|32->15|33->16|34->17|34->17|35->18|35->18|35->18|36->19|36->19|36->19|36->19|41->24|41->24|43->26|43->26|44->27|46->29|46->29|47->30|47->30|49->32|50->33|51->34|51->34|52->35|53->36|53->36|55->38|55->38|55->38|56->39|59->42|59->42|61->44|61->44|61->44|62->45|66->49|66->49|68->51|68->51|68->51|69->52|73->56|73->56|74->57
                  -- GENERATED --
              */
          