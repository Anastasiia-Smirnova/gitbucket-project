
package gitbucket.core.issues.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object editissue extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Option[String],Int,gitbucket.core.service.RepositoryService.RepositoryInfo,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(content: Option[String], issueId: Int,
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/gitbucket/*3.11*/.core.helper.html.preview(
  repository         = repository,
  content            = content.getOrElse(""),
  enableWikiLink     = false,
  enableRefsLink     = true,
  enableLineBreaks   = true,
  enableTaskList     = true,
  hasWritePermission = true,
  completionContext  = "issues",
  style              = "",
  elastic            = true,
  focus              = true,
  tabIndex           = 1
)),format.raw/*16.2*/("""
"""),format.raw/*17.1*/("""<div class="pull-right">
  <input type="button" id="cancel-issue" class="btn btn-default" value="Cancel"/>
  <input type="button" id="update-issue" class="btn btn-success" value="Update comment"/>
</div>
<script>
$(function()"""),format.raw/*22.13*/("""{"""),format.raw/*22.14*/("""
  """),format.raw/*23.3*/("""var callback = function(data)"""),format.raw/*23.32*/("""{"""),format.raw/*23.33*/("""
    """),format.raw/*24.5*/("""$('#update, #cancel').removeAttr('disabled');
    $('#issueContent').empty().html(data.content);
    prettyPrint();
  """),format.raw/*27.3*/("""}"""),format.raw/*27.4*/(""";

  $('#update-issue').click(function()"""),format.raw/*29.38*/("""{"""),format.raw/*29.39*/("""
    """),format.raw/*30.5*/("""var content = $(this).parent().parent().find('textarea[name=content]').val();
    $('#update, #cancel').attr('disabled', 'disabled');
    $.ajax("""),format.raw/*32.12*/("""{"""),format.raw/*32.13*/("""
      """),format.raw/*33.7*/("""url: '"""),_display_(/*33.14*/context/*33.21*/.path),format.raw/*33.26*/("""/"""),_display_(/*33.28*/repository/*33.38*/.owner),format.raw/*33.44*/("""/"""),_display_(/*33.46*/repository/*33.56*/.name),format.raw/*33.61*/("""/issues/edit/"""),_display_(/*33.75*/issueId),format.raw/*33.82*/("""',
      type: 'POST',
      data: """),format.raw/*35.13*/("""{"""),format.raw/*35.14*/(""" """),format.raw/*35.15*/("""content : content """),format.raw/*35.33*/("""}"""),format.raw/*35.34*/("""
    """),format.raw/*36.5*/("""}"""),format.raw/*36.6*/(""").done(
      callback
    ).fail(function(req) """),format.raw/*38.26*/("""{"""),format.raw/*38.27*/("""
      """),format.raw/*39.7*/("""$('#update, #cancel').removeAttr('disabled');
    """),format.raw/*40.5*/("""}"""),format.raw/*40.6*/(""");
  """),format.raw/*41.3*/("""}"""),format.raw/*41.4*/(""");

  $('#cancel-issue').click(function()"""),format.raw/*43.38*/("""{"""),format.raw/*43.39*/("""
    """),format.raw/*44.5*/("""$('#update, #cancel').attr('disabled', 'disabled');
    $.get('"""),_display_(/*45.13*/context/*45.20*/.path),format.raw/*45.25*/("""/"""),_display_(/*45.27*/repository/*45.37*/.owner),format.raw/*45.43*/("""/"""),_display_(/*45.45*/repository/*45.55*/.name),format.raw/*45.60*/("""/issues/_data/"""),_display_(/*45.75*/issueId),format.raw/*45.82*/("""', callback);
    return false;
  """),format.raw/*47.3*/("""}"""),format.raw/*47.4*/(""");
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/(""");
</script>
"""))
      }
    }
  }

  def render(content:Option[String],issueId:Int,repository:gitbucket.core.service.RepositoryService.RepositoryInfo,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(content,issueId,repository)(context)

  def f:((Option[String],Int,gitbucket.core.service.RepositoryService.RepositoryInfo) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (content,issueId,repository) => (context) => apply(content,issueId,repository)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/issues/editissue.scala.html
                  HASH: 9a758f6d9f0d83b30d695c9fd7aecd6928c0e101
                  MATRIX: 688->1|945->166|962->175|1380->573|1408->574|1661->799|1690->800|1720->803|1777->832|1806->833|1838->838|1983->956|2011->957|2079->997|2108->998|2140->1003|2313->1148|2342->1149|2376->1156|2410->1163|2426->1170|2452->1175|2481->1177|2500->1187|2527->1193|2556->1195|2575->1205|2601->1210|2642->1224|2670->1231|2733->1266|2762->1267|2791->1268|2837->1286|2866->1287|2898->1292|2926->1293|3002->1341|3031->1342|3065->1349|3142->1399|3170->1400|3202->1405|3230->1406|3299->1447|3328->1448|3360->1453|3451->1517|3467->1524|3493->1529|3522->1531|3541->1541|3568->1547|3597->1549|3616->1559|3642->1564|3684->1579|3712->1586|3773->1620|3801->1621|3831->1624|3859->1625
                  LINES: 14->1|20->3|20->3|33->16|34->17|39->22|39->22|40->23|40->23|40->23|41->24|44->27|44->27|46->29|46->29|47->30|49->32|49->32|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|50->33|52->35|52->35|52->35|52->35|52->35|53->36|53->36|55->38|55->38|56->39|57->40|57->40|58->41|58->41|60->43|60->43|61->44|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|62->45|64->47|64->47|65->48|65->48
                  -- GENERATED --
              */
          