
package gitbucket.core.helper.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object diff extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template9[Seq[gitbucket.core.util.JGitUtil.DiffInfo],gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String],Option[String],Boolean,Option[Int],Boolean,Boolean,gitbucket.core.controller.Context,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(diffs: Seq[gitbucket.core.util.JGitUtil.DiffInfo],
  repository: gitbucket.core.service.RepositoryService.RepositoryInfo,
  newCommitId: Option[String],
  oldCommitId: Option[String],
  showIndex: Boolean,
  issueId: Option[Int],
  hasWritePermission: Boolean,
  showLineNotes: Boolean)(implicit context: gitbucket.core.controller.Context):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*9.2*/import gitbucket.core.view.helpers
/*10.2*/import org.eclipse.jgit.diff.DiffEntry.ChangeType


Seq[Any](format.raw/*11.1*/("""<style>
  th.line-num """),format.raw/*12.15*/("""{"""),format.raw/*12.16*/("""
    """),format.raw/*13.5*/("""cursor: pointer;
  """),format.raw/*14.3*/("""}"""),format.raw/*14.4*/("""
"""),format.raw/*15.1*/("""</style>
"""),_display_(if(showIndex)/*16.15*/{_display_(Seq[Any](format.raw/*16.16*/("""
  """),format.raw/*17.3*/("""<div class="pull-right" style="margin-bottom: 10px;">
    """),_display_(if(oldCommitId.isEmpty && newCommitId.isDefined)/*18.54*/ {_display_(Seq[Any](format.raw/*18.56*/("""
      """),format.raw/*19.7*/("""<a href=""""),_display_(/*19.17*/helpers/*19.24*/.url(repository)),format.raw/*19.40*/("""/patch/"""),_display_(/*19.48*/newCommitId),format.raw/*19.59*/("""" class="btn btn-default">Patch</a>
    """)))} else {null} ),format.raw/*20.6*/("""
    """),_display_(if(oldCommitId.isDefined && newCommitId.isDefined)/*21.56*/ {_display_(Seq[Any](format.raw/*21.58*/("""
      """),format.raw/*22.7*/("""<a href=""""),_display_(/*22.17*/helpers/*22.24*/.url(repository)),format.raw/*22.40*/("""/patch/"""),_display_(/*22.48*/oldCommitId),format.raw/*22.59*/("""..."""),_display_(/*22.63*/newCommitId),format.raw/*22.74*/("""" class="btn btn-default">Patch</a>
    """)))} else {null} ),format.raw/*23.6*/("""
    """),format.raw/*24.5*/("""<div class="btn-group">
      <a href="javascript:changeDisplaySetting('diff', 'unified');" id="btn-unified" class="btn btn-default">Unified</a>
      <a href="javascript:changeDisplaySetting('diff', 'split');" id="btn-split" class="btn btn-default">Split</a>
    </div>
  </div>
  Showing <a href="javascript:void(0);" id="toggle-file-list">"""),_display_(/*29.64*/diffs/*29.69*/.size),format.raw/*29.74*/(""" """),format.raw/*29.75*/("""changed """),_display_(/*29.84*/helpers/*29.91*/.plural(diffs.size, "file")),format.raw/*29.118*/("""</a>
  <ul id="commit-file-list" style="display: none;">
  """),_display_(/*31.4*/diffs/*31.9*/.zipWithIndex.map/*31.26*/ { case (diff, i) =>_display_(Seq[Any](format.raw/*31.46*/("""
    """),format.raw/*32.5*/("""<li class="border">
      <span class="pull-right diffstat" data-diff-id=""""),_display_(/*33.56*/i),format.raw/*33.57*/(""""></span>
      <a href="#diff-"""),_display_(/*34.23*/i),format.raw/*34.24*/("""">
        """),_display_(if(diff.changeType == ChangeType.COPY || diff.changeType == ChangeType.RENAME)/*35.88*/{_display_(Seq[Any](format.raw/*35.89*/("""
          """),format.raw/*36.11*/("""<i class="octicon octicon-diff-renamed"></i> """),_display_(/*36.57*/diff/*36.61*/.oldPath),format.raw/*36.69*/(""" """),format.raw/*36.70*/("""-> """),_display_(/*36.74*/diff/*36.78*/.newPath),format.raw/*36.86*/("""
        """)))} else {null} ),format.raw/*37.10*/("""
        """),_display_(if(diff.changeType == ChangeType.ADD)/*38.47*/{_display_(Seq[Any](format.raw/*38.48*/("""
          """),format.raw/*39.11*/("""<i class="octicon octicon-diff-added"></i> """),_display_(/*39.55*/diff/*39.59*/.newPath),format.raw/*39.67*/("""
        """)))} else {null} ),format.raw/*40.10*/("""
        """),_display_(if(diff.changeType == ChangeType.MODIFY)/*41.50*/{_display_(Seq[Any](format.raw/*41.51*/("""
          """),format.raw/*42.11*/("""<i class="octicon octicon-diff-modified"></i> """),_display_(/*42.58*/diff/*42.62*/.newPath),format.raw/*42.70*/("""
        """)))} else {null} ),format.raw/*43.10*/("""
        """),_display_(if(diff.changeType == ChangeType.DELETE)/*44.50*/{_display_(Seq[Any](format.raw/*44.51*/("""
          """),format.raw/*45.11*/("""<i class="octicon octicon-diff-removed"></i> """),_display_(/*45.57*/diff/*45.61*/.oldPath),format.raw/*45.69*/("""
        """)))} else {null} ),format.raw/*46.10*/("""
      """),format.raw/*47.7*/("""</a>
    </li>
    """)))}),format.raw/*49.6*/("""
  """),format.raw/*50.3*/("""</ul>
""")))} else {null} ),format.raw/*51.2*/("""
"""),_display_(/*52.2*/diffs/*52.7*/.zipWithIndex.map/*52.24*/ { case (diff, i) =>_display_(Seq[Any](format.raw/*52.44*/("""
  """),format.raw/*53.3*/("""<a name="diff-"""),_display_(/*53.18*/i),format.raw/*53.19*/(""""></a>
  <table class="table table-bordered diff-outside" commitId=""""),_display_(/*54.63*/newCommitId),format.raw/*54.74*/("""" fileName=""""),_display_(/*54.87*/diff/*54.91*/.newPath),format.raw/*54.99*/("""" data-diff-id=""""),_display_(/*54.116*/i),format.raw/*54.117*/("""">
    <tr>
      <th style="font-weight: normal;" class="box-header">
        <i class="fa fa-chevron-down rotate" data-toggle="collapse" data-target=".diff-collapse-"""),_display_(/*57.98*/i),format.raw/*57.99*/("""" aria-hidden="true" style="cursor: pointer; font-size: 12px"></i>
        """),_display_(if(diff.changeType == ChangeType.COPY || diff.changeType == ChangeType.RENAME)/*58.88*/{_display_(Seq[Any](format.raw/*58.89*/("""
          """),_display_(if(newCommitId.isDefined)/*59.37*/{_display_(Seq[Any](format.raw/*59.38*/("""
            """),format.raw/*60.13*/("""<div class="pull-right align-right">
              <label class="no-margin"><input type="checkbox" class="ignore-whitespace" value="1"/> Ignore Space</label>
              <label class="no-margin"><input type="checkbox" class="toggle-notes" checked> Show notes</label>
              <a href=""""),_display_(/*63.25*/helpers/*63.32*/.url(repository)),format.raw/*63.48*/("""/blob/"""),_display_(/*63.55*/newCommitId/*63.66*/.get),format.raw/*63.70*/("""/"""),_display_(/*63.72*/diff/*63.76*/.newPath),format.raw/*63.84*/("""" class="btn btn-default btn-sm" title="View the whole file at version """),_display_(/*63.156*/newCommitId/*63.167*/.get.substring(0, 10)),format.raw/*63.188*/("""" data-toggle="tooltip">View</a>
            </div>
          """)))} else {null} ),format.raw/*65.12*/("""
          """),format.raw/*66.11*/("""<span class="diffstat"><i class="octicon octicon-diff-renamed"></i></span>
          <a href="#diff-"""),_display_(/*67.27*/helpers/*67.34*/.md5(diff.newPath)),format.raw/*67.52*/("""" id="diff-"""),_display_(/*67.64*/helpers/*67.71*/.md5(diff.newPath)),format.raw/*67.89*/("""" class="file-hash"><span class="strong">"""),_display_(/*67.131*/diff/*67.135*/.oldPath),format.raw/*67.143*/(""" """),format.raw/*67.144*/("""→ """),_display_(/*67.147*/diff/*67.151*/.newPath),format.raw/*67.159*/("""</span></a>
        """)))} else {null} ),format.raw/*68.10*/("""
        """),_display_(if(diff.changeType == ChangeType.ADD || diff.changeType == ChangeType.MODIFY)/*69.87*/{_display_(Seq[Any](format.raw/*69.88*/("""
          """),_display_(if(newCommitId.isDefined)/*70.37*/{_display_(Seq[Any](format.raw/*70.38*/("""
            """),format.raw/*71.13*/("""<div class="pull-right align-right">
              <label class="no-margin"><input type="checkbox" class="ignore-whitespace" value="1"/> Ignore Space</label>
              <label class="no-margin"><input type="checkbox" class="toggle-notes" checked> Show notes</label>
              <a href=""""),_display_(/*74.25*/helpers/*74.32*/.url(repository)),format.raw/*74.48*/("""/blob/"""),_display_(/*74.55*/newCommitId/*74.66*/.get),format.raw/*74.70*/("""/"""),_display_(/*74.72*/diff/*74.76*/.newPath),format.raw/*74.84*/("""" class="btn btn-default btn-sm" title="View the whole file at version """),_display_(/*74.156*/newCommitId/*74.167*/.get.substring(0, 10)),format.raw/*74.188*/("""" data-toggle="tooltip">View</a>
            </div>
          """)))} else {null} ),format.raw/*76.12*/("""
          """),format.raw/*77.11*/("""<span class="diffstat">
          """),_display_(if(diff.changeType == ChangeType.ADD)/*78.49*/{_display_(Seq[Any](format.raw/*78.50*/("""
            """),format.raw/*79.13*/("""<i class="octicon octicon-diff-added"></i>
          """)))}else/*80.18*/{_display_(Seq[Any](format.raw/*80.19*/("""
            """),format.raw/*81.13*/("""<i class="octicon octicon-diff-modified"></i>
          """)))}),format.raw/*82.12*/("""
          """),format.raw/*83.11*/("""</span>
          <a href="#diff-"""),_display_(/*84.27*/helpers/*84.34*/.md5(diff.newPath)),format.raw/*84.52*/("""" id="diff-"""),_display_(/*84.64*/helpers/*84.71*/.md5(diff.newPath)),format.raw/*84.89*/("""" class="file-hash"><span class="strong">"""),_display_(/*84.131*/diff/*84.135*/.newPath),format.raw/*84.143*/("""</span></a>
        """)))} else {null} ),format.raw/*85.10*/("""
        """),_display_(if(diff.changeType == ChangeType.DELETE)/*86.50*/{_display_(Seq[Any](format.raw/*86.51*/("""
          """),_display_(if(oldCommitId.isDefined)/*87.37*/{_display_(Seq[Any](format.raw/*87.38*/("""
            """),format.raw/*88.13*/("""<div class="pull-right align-right">
              <label class="no-margin"><input type="checkbox" class="toggle-notes" checked> Show notes</label>
              <a href=""""),_display_(/*90.25*/helpers/*90.32*/.url(repository)),format.raw/*90.48*/("""/blob/"""),_display_(/*90.55*/oldCommitId/*90.66*/.get),format.raw/*90.70*/("""/"""),_display_(/*90.72*/diff/*90.76*/.oldPath),format.raw/*90.84*/("""" class="btn btn-default btn-sm" title="View the whole file at version """),_display_(/*90.156*/oldCommitId/*90.167*/.get.substring(0, 10)),format.raw/*90.188*/("""" data-toggle="tooltip">View</a>
            </div>
          """)))} else {null} ),format.raw/*92.12*/("""
          """),format.raw/*93.11*/("""<span class="diffstat"><i class="octicon octicon-diff-removed"></i></span>
          <a href="#diff-"""),_display_(/*94.27*/helpers/*94.34*/.md5(diff.oldPath)),format.raw/*94.52*/("""" id="diff-"""),_display_(/*94.64*/helpers/*94.71*/.md5(diff.oldPath)),format.raw/*94.89*/("""" class="file-hash"><span class="strong">"""),_display_(/*94.131*/diff/*94.135*/.oldPath),format.raw/*94.143*/("""</span></a>
        """)))} else {null} ),format.raw/*95.10*/("""
        """),_display_(if(diff.oldMode != diff.newMode)/*96.42*/{_display_(Seq[Any](format.raw/*96.43*/("""
          """),format.raw/*97.11*/("""<span class="monospace">"""),_display_(/*97.36*/diff/*97.40*/.oldMode),format.raw/*97.48*/(""" """),format.raw/*97.49*/("""→ """),_display_(/*97.52*/diff/*97.56*/.newMode),format.raw/*97.64*/("""</span>
        """)))} else {null} ),format.raw/*98.10*/("""
      """),format.raw/*99.7*/("""</th>
    </tr>
    <tr class="diff-collapse-"""),_display_(/*101.31*/i),format.raw/*101.32*/(""" """),format.raw/*101.33*/("""collapse in">
      <td style="padding: 0;">
        """),_display_(if(diff.tooLarge)/*103.27*/ {_display_(Seq[Any](format.raw/*103.29*/("""
          """),format.raw/*104.11*/("""<div style="padding: 12px;" id="show-diff-"""),_display_(/*104.54*/i),format.raw/*104.55*/("""">
            """),_display_(if(oldCommitId.isEmpty && newCommitId.isDefined)/*105.62*/ {_display_(Seq[Any](format.raw/*105.64*/("""
              """),format.raw/*106.15*/("""Too large (<a href="javascript:showDiff("""),_display_(/*106.56*/i),format.raw/*106.57*/(""", '', '"""),_display_(/*106.65*/newCommitId),format.raw/*106.76*/("""', '"""),_display_(/*106.81*/diff/*106.85*/.newPath),format.raw/*106.93*/("""')">Show diff</a>)
            """)))} else {null} ),format.raw/*107.14*/("""
            """),_display_(if(oldCommitId.isDefined && newCommitId.isDefined)/*108.64*/ {_display_(Seq[Any](format.raw/*108.66*/("""
              """),format.raw/*109.15*/("""Too large (<a href="javascript:showDiff("""),_display_(/*109.56*/i),format.raw/*109.57*/(""", '"""),_display_(/*109.61*/oldCommitId),format.raw/*109.72*/("""', '"""),_display_(/*109.77*/newCommitId),format.raw/*109.88*/("""', '"""),_display_(/*109.93*/diff/*109.97*/.newPath),format.raw/*109.105*/("""')">Show diff</a>)
            """)))} else {null} ),format.raw/*110.14*/("""
          """),format.raw/*111.11*/("""</div>
          <div id="diffText-"""),_display_(/*112.30*/i),format.raw/*112.31*/("""" class="diffText"></div>
          <input type="hidden" id="newText-"""),_display_(/*113.45*/i),format.raw/*113.46*/("""" data-file-name=""""),_display_(/*113.65*/diff/*113.69*/.newPath),format.raw/*113.77*/("""" data-val="">
          <input type="hidden" id="oldText-"""),_display_(/*114.45*/i),format.raw/*114.46*/("""" data-file-name=""""),_display_(/*114.65*/diff/*114.69*/.oldPath),format.raw/*114.77*/("""" data-val="">
        """)))}else/*115.16*/{_display_(Seq[Any](format.raw/*115.17*/("""
          """),_display_(if(diff.oldObjectId == diff.newObjectId)/*116.52*/ {_display_(Seq[Any](format.raw/*116.54*/("""
            """),_display_(if(diff.oldPath != diff.newPath)/*117.46*/ {_display_(Seq[Any](format.raw/*117.48*/("""
              """),format.raw/*118.15*/("""<div class="diff-same">File renamed without changes</div>
            """)))}else/*119.20*/{_display_(Seq[Any](format.raw/*119.21*/("""
              """),format.raw/*120.15*/("""<div class="diff-same">File mode changed</div>
            """)))}),format.raw/*121.14*/("""
          """)))}else/*122.18*/{_display_(Seq[Any](format.raw/*122.19*/("""
            """),_display_(if(diff.newContent != None || diff.oldContent != None)/*123.68*/{_display_(Seq[Any](format.raw/*123.69*/("""
              """),format.raw/*124.15*/("""<div id="diffText-"""),_display_(/*124.34*/i),format.raw/*124.35*/("""" class="diffText"></div>
              <input type="hidden" id="newText-"""),_display_(/*125.49*/i),format.raw/*125.50*/("""" data-file-name=""""),_display_(/*125.69*/diff/*125.73*/.newPath),format.raw/*125.81*/("""" data-val=""""),_display_(/*125.94*/diff/*125.98*/.newContent),format.raw/*125.109*/("""">
              <input type="hidden" id="oldText-"""),_display_(/*126.49*/i),format.raw/*126.50*/("""" data-file-name=""""),_display_(/*126.69*/diff/*126.73*/.oldPath),format.raw/*126.81*/("""" data-val=""""),_display_(/*126.94*/diff/*126.98*/.oldContent),format.raw/*126.109*/("""">
            """)))}else/*127.20*/{_display_(Seq[Any](format.raw/*127.21*/("""
              """),_display_(if(diff.newIsImage || diff.oldIsImage)/*128.54*/{_display_(Seq[Any](format.raw/*128.55*/("""
                """),format.raw/*129.17*/("""<div class="diff-image-render diff2up">
                  """),_display_(if(oldCommitId.isDefined && diff.oldIsImage)/*130.64*/{_display_(Seq[Any](format.raw/*130.65*/("""
                    """),format.raw/*131.21*/("""<div class="diff-image-frame diff-old"><img src=""""),_display_(/*131.71*/helpers/*131.78*/.url(repository)),format.raw/*131.94*/("""/raw/"""),_display_(/*131.100*/oldCommitId/*131.111*/.get),format.raw/*131.115*/("""/"""),_display_(/*131.117*/diff/*131.121*/.oldPath),format.raw/*131.129*/("""" class="diff-image" onload="onLoadedDiffImages(this)" style="display:none" /></div>
                  """)))}else/*132.26*/{_display_(Seq[Any](format.raw/*132.27*/("""
                    """),_display_(if(diff.changeType != ChangeType.ADD)/*133.59*/{_display_(Seq[Any](format.raw/*133.60*/("""
                      """),format.raw/*134.23*/("""<div style="padding: 12px;">Not supported</div>
                    """)))} else {null} ),format.raw/*135.22*/("""
                  """)))}),format.raw/*136.20*/("""
                  """),_display_(if(newCommitId.isDefined && diff.newIsImage)/*137.64*/{_display_(Seq[Any](format.raw/*137.65*/("""
                    """),format.raw/*138.21*/("""<div class="diff-image-frame diff-new"><img src=""""),_display_(/*138.71*/helpers/*138.78*/.url(repository)),format.raw/*138.94*/("""/raw/"""),_display_(/*138.100*/newCommitId/*138.111*/.get),format.raw/*138.115*/("""/"""),_display_(/*138.117*/diff/*138.121*/.newPath),format.raw/*138.129*/("""" class="diff-image" onload="onLoadedDiffImages(this)" style="display:none" /></div>
                  """)))}else/*139.26*/{_display_(Seq[Any](format.raw/*139.27*/("""
                    """),_display_(if(diff.changeType != ChangeType.DELETE)/*140.62*/{_display_(Seq[Any](format.raw/*140.63*/("""
                      """),format.raw/*141.23*/("""<div style="padding: 12px;">Not supported</div>
                    """)))} else {null} ),format.raw/*142.22*/("""
                  """)))}),format.raw/*143.20*/("""
                """),format.raw/*144.17*/("""</div>
              """)))}else/*145.22*/{_display_(Seq[Any](format.raw/*145.23*/("""
                """),format.raw/*146.17*/("""<div style="padding: 12px;">Not supported</div>
              """)))}),format.raw/*147.16*/("""
            """)))}),format.raw/*148.14*/("""
          """)))}),format.raw/*149.12*/("""
        """)))}),format.raw/*150.10*/("""
      """),format.raw/*151.7*/("""</td>
    </tr>
  </table>
""")))}),format.raw/*154.2*/("""
"""),format.raw/*155.1*/("""<script type="text/javascript" src=""""),_display_(/*155.38*/helpers/*155.45*/.assets("/vendors/jsdifflib/difflib.js")),format.raw/*155.85*/(""""></script>
<link href=""""),_display_(/*156.14*/helpers/*156.21*/.assets("/vendors/jsdifflib/diffview.css")),format.raw/*156.63*/("""" type="text/css" rel="stylesheet" />
<script>

$(".rotate").click(function()"""),format.raw/*159.30*/("""{"""),format.raw/*159.31*/("""
    """),format.raw/*160.5*/("""if($(this).hasClass('fa-chevron-right')) """),format.raw/*160.46*/("""{"""),format.raw/*160.47*/("""
      """),format.raw/*161.7*/("""$(this).removeClass('fa-chevron-right');
      $(this).addClass('fa-chevron-down');
    """),format.raw/*163.5*/("""}"""),format.raw/*163.6*/(""" """),format.raw/*163.7*/("""else """),format.raw/*163.12*/("""{"""),format.raw/*163.13*/("""
      """),format.raw/*164.7*/("""$(this).removeClass('fa-chevron-down');
      $(this).addClass('fa-chevron-right');
    """),format.raw/*166.5*/("""}"""),format.raw/*166.6*/("""
"""),format.raw/*167.1*/("""}"""),format.raw/*167.2*/(""");

$(function()"""),format.raw/*169.13*/("""{"""),format.raw/*169.14*/("""
  """),_display_(if(showIndex)/*170.17*/{_display_(Seq[Any](format.raw/*170.18*/("""
    """),format.raw/*171.5*/("""$('#toggle-file-list').click(function()"""),format.raw/*171.44*/("""{"""),format.raw/*171.45*/("""
      """),format.raw/*172.7*/("""$('#commit-file-list').toggle();
      if($(this).val() == 'Show file list')"""),format.raw/*173.44*/("""{"""),format.raw/*173.45*/("""
        """),format.raw/*174.9*/("""$(this).val('Hide file list');
      """),format.raw/*175.7*/("""}"""),format.raw/*175.8*/(""" """),format.raw/*175.9*/("""else """),format.raw/*175.14*/("""{"""),format.raw/*175.15*/("""
        """),format.raw/*176.9*/("""$(this).val('Show file list');
      """),format.raw/*177.7*/("""}"""),format.raw/*177.8*/("""
    """),format.raw/*178.5*/("""}"""),format.raw/*178.6*/(""");
  """)))} else {null} ),format.raw/*179.4*/("""

  """),format.raw/*181.3*/("""window.params = """),format.raw/*181.19*/("""{"""),format.raw/*181.20*/("""}"""),format.raw/*181.21*/(""";

  // Render diffs as unified mode initially
  if(("&" + location.search.substring(1)).indexOf("&w=1") != -1)"""),format.raw/*184.65*/("""{"""),format.raw/*184.66*/("""
    """),format.raw/*185.5*/("""$('.ignore-whitespace').prop('checked', true);
    window.params['w'] = 1;
  """),format.raw/*187.3*/("""}"""),format.raw/*187.4*/("""
  """),format.raw/*188.3*/("""if(("&" + location.search.substring(1)).indexOf("&diff=split") != -1)"""),format.raw/*188.72*/("""{"""),format.raw/*188.73*/("""
    """),format.raw/*189.5*/("""window.viewType = 0;
    $('#btn-split').addClass('active');
    window.params['diff'] = 'split';
  """),format.raw/*192.3*/("""}"""),format.raw/*192.4*/(""" """),format.raw/*192.5*/("""else """),format.raw/*192.10*/("""{"""),format.raw/*192.11*/("""
    """),format.raw/*193.5*/("""window.viewType = 1;
    $('#btn-unified').addClass('active');
  """),format.raw/*195.3*/("""}"""),format.raw/*195.4*/("""
  """),format.raw/*196.3*/("""renderDiffs();

  window.onhashchange = function()"""),format.raw/*198.35*/("""{"""),format.raw/*198.36*/("""
    """),format.raw/*199.5*/("""updateHighlighting();
  """),format.raw/*200.3*/("""}"""),format.raw/*200.4*/("""

  """),format.raw/*202.3*/("""$('.toggle-notes').change(function() """),format.raw/*202.40*/("""{"""),format.raw/*202.41*/("""
    """),format.raw/*203.5*/("""if (!$(this).prop('checked')) """),format.raw/*203.35*/("""{"""),format.raw/*203.36*/("""
      """),format.raw/*204.7*/("""$(this).closest('table').find('.not-diff.inline-comment-form').remove();
    """),format.raw/*205.5*/("""}"""),format.raw/*205.6*/("""
    """),format.raw/*206.5*/("""$(this).closest('table').find('.not-diff').toggle();
  """),format.raw/*207.3*/("""}"""),format.raw/*207.4*/(""");

  $('.ignore-whitespace').change(function() """),format.raw/*209.45*/("""{"""),format.raw/*209.46*/("""
    """),format.raw/*210.5*/("""renderOneDiff($(this).closest("table").find(".diffText"), window.viewType, $(this).closest("table").find(".file-hash")[0].id);
  """),format.raw/*211.3*/("""}"""),format.raw/*211.4*/(""");

  if (typeof $('#show-notes')[0] !== 'undefined' && !$('#show-notes')[0].checked) """),format.raw/*213.83*/("""{"""),format.raw/*213.84*/("""
    """),format.raw/*214.5*/("""$('#comment-list').children('.inline-comment').hide();
  """),format.raw/*215.3*/("""}"""),format.raw/*215.4*/("""

  """),format.raw/*217.3*/("""// Add comment button
  $('.diff-outside').on('click','table.diff .add-comment',function() """),format.raw/*218.70*/("""{"""),format.raw/*218.71*/("""
    """),format.raw/*219.5*/("""const $this  = $(this);
    const $tr    = $this.closest('tr');
    const $check = $this.closest('table:not(.diff)').find('.toggle-notes');
    if (!$check.prop('checked')) """),format.raw/*222.34*/("""{"""),format.raw/*222.35*/("""
      """),format.raw/*223.7*/("""$check.prop('checked', true).trigger('change');
    """),format.raw/*224.5*/("""}"""),format.raw/*224.6*/("""
    """),format.raw/*225.5*/("""if (!$tr.nextAll(':not(.not-diff):first').prev().hasClass('inline-comment-form')) """),format.raw/*225.87*/("""{"""),format.raw/*225.88*/("""
      """),format.raw/*226.7*/("""const commitId = $this.closest('.table-bordered').attr('commitId'),
      fileName = $this.closest('.table-bordered').attr('fileName');
      let oldLineNumber, newLineNumber;
      if (window.viewType == 0) """),format.raw/*229.33*/("""{"""),format.raw/*229.34*/("""
        """),format.raw/*230.9*/("""oldLineNumber = $this.parent().prev('.oldline').attr('line-number');
        newLineNumber = $this.parent().prev('.newline').attr('line-number');
      """),format.raw/*232.7*/("""}"""),format.raw/*232.8*/(""" """),format.raw/*232.9*/("""else """),format.raw/*232.14*/("""{"""),format.raw/*232.15*/("""
        """),format.raw/*233.9*/("""oldLineNumber = $this.parent().prevAll('.oldline').attr('line-number');
        newLineNumber = $this.parent().prevAll('.newline').attr('line-number');
      """),format.raw/*235.7*/("""}"""),format.raw/*235.8*/("""

      """),format.raw/*237.7*/("""showCommentForm(commitId, fileName, oldLineNumber, newLineNumber, $tr);
    """),format.raw/*238.5*/("""}"""),format.raw/*238.6*/("""
  """),format.raw/*239.3*/("""}"""),format.raw/*239.4*/(""").on('click', 'table.diff .btn-default', function() """),format.raw/*239.56*/("""{"""),format.raw/*239.57*/("""
    """),format.raw/*240.5*/("""// Cancel comment form
    $(this).closest('.not-diff').prev().find('.reply-comment').closest('.not-diff').show();
    $(this).closest('.inline-comment-form').remove();
  """),format.raw/*243.3*/("""}"""),format.raw/*243.4*/(""");

  // Reply comment
  $('.diff-outside').on('click', '.reply-comment',function()"""),format.raw/*246.61*/("""{"""),format.raw/*246.62*/("""
    """),format.raw/*247.5*/("""const $this = $(this);
    const $tr    = $this.closest('tr');
    const commitId = $this.closest('.table-bordered').attr('commitId');
    const fileName = $this.data('filename');
    const oldLineNumber = $this.data('oldline');
    const newLineNumber = $this.data('newline');

    showCommentForm(commitId, fileName, oldLineNumber, newLineNumber, $tr);
  """),format.raw/*255.3*/("""}"""),format.raw/*255.4*/(""");

  // Line selection
  $('.diff-outside').on('click','table.diff th.line-num',function(e) """),format.raw/*258.70*/("""{"""),format.raw/*258.71*/("""
    """),format.raw/*259.5*/("""const $this   = $(this);
    const hash    = location.hash;
    const baseUrl = location.toString().split("#")[0];

    if (e.shiftKey == true && hash.match(/#diff-\w+-L\d+(-L\d+)?/)) """),format.raw/*263.69*/("""{"""),format.raw/*263.70*/("""
      """),format.raw/*264.7*/("""const fragments = hash.split('-');
      window.history.pushState('', '', baseUrl + '#diff-' + fragments[1] + '-' + fragments[2] + '-' + $this[0].id.split('-')[2]);
    """),format.raw/*266.5*/("""}"""),format.raw/*266.6*/(""" """),format.raw/*266.7*/("""else """),format.raw/*266.12*/("""{"""),format.raw/*266.13*/("""
      """),format.raw/*267.7*/("""window.history.pushState('', '', baseUrl + '#' + $this[0].id);
    """),format.raw/*268.5*/("""}"""),format.raw/*268.6*/("""
    """),format.raw/*269.5*/("""getSelection().empty();
    updateHighlighting();
  """),format.raw/*271.3*/("""}"""),format.raw/*271.4*/(""");
"""),format.raw/*272.1*/("""}"""),format.raw/*272.2*/(""");

function getInlineContainer(where) """),format.raw/*274.36*/("""{"""),format.raw/*274.37*/("""
  """),format.raw/*275.3*/("""if (window.viewType == 0) """),format.raw/*275.29*/("""{"""),format.raw/*275.30*/("""
    """),format.raw/*276.5*/("""if (where === 'new') """),format.raw/*276.26*/("""{"""),format.raw/*276.27*/("""
      """),format.raw/*277.7*/("""return $('<tr class="not-diff"><td colspan="2"></td><td colspan="2" class="comment-box-container"></td></tr>');
    """),format.raw/*278.5*/("""}"""),format.raw/*278.6*/(""" """),format.raw/*278.7*/("""else """),format.raw/*278.12*/("""{"""),format.raw/*278.13*/("""
      """),format.raw/*279.7*/("""return $('<tr class="not-diff"><td colspan="2" class="comment-box-container"></td><td colspan="2"></td></tr>');
    """),format.raw/*280.5*/("""}"""),format.raw/*280.6*/("""
  """),format.raw/*281.3*/("""}"""),format.raw/*281.4*/("""
  """),format.raw/*282.3*/("""return $('<tr class="not-diff"><td colspan="3" class="comment-box-container"></td></tr>');
"""),format.raw/*283.1*/("""}"""),format.raw/*283.2*/("""

"""),format.raw/*285.1*/("""function showCommentForm(commitId, fileName, oldLineNumber, newLineNumber, $tr)"""),format.raw/*285.80*/("""{"""),format.raw/*285.81*/("""
  """),format.raw/*286.3*/("""// assemble Ajax url
  let url = '"""),_display_(/*287.15*/helpers/*287.22*/.url(repository)),format.raw/*287.38*/("""/commit/' + commitId + '/comment/_form?fileName=' + fileName"""),_display_(/*287.99*/issueId/*287.106*/.map/*287.110*/ { id =>_display_(Seq[Any](format.raw/*287.118*/(""" """),format.raw/*287.119*/("""+ '&issueId="""),_display_(/*287.132*/id),format.raw/*287.134*/("""' """)))}),format.raw/*287.137*/(""";
  if (!isNaN(oldLineNumber) && oldLineNumber) """),format.raw/*288.47*/("""{"""),format.raw/*288.48*/("""
    """),format.raw/*289.5*/("""url += ('&oldLineNumber=' + oldLineNumber)
  """),format.raw/*290.3*/("""}"""),format.raw/*290.4*/("""
  """),format.raw/*291.3*/("""if (!isNaN(newLineNumber) && newLineNumber) """),format.raw/*291.47*/("""{"""),format.raw/*291.48*/("""
    """),format.raw/*292.5*/("""url += ('&newLineNumber=' + newLineNumber)
  """),format.raw/*293.3*/("""}"""),format.raw/*293.4*/("""
  """),format.raw/*294.3*/("""// send Ajax request
  $.get(url, """),format.raw/*295.14*/("""{"""),format.raw/*295.15*/(""" """),format.raw/*295.16*/("""dataType : 'html' """),format.raw/*295.34*/("""}"""),format.raw/*295.35*/(""", function(responseContent) """),format.raw/*295.63*/("""{"""),format.raw/*295.64*/("""
    """),format.raw/*296.5*/("""// create container
    let tmp;
    if (!isNaN(oldLineNumber) && oldLineNumber) """),format.raw/*298.49*/("""{"""),format.raw/*298.50*/("""
      """),format.raw/*299.7*/("""if (!isNaN(newLineNumber) && newLineNumber) """),format.raw/*299.51*/("""{"""),format.raw/*299.52*/("""
        """),format.raw/*300.9*/("""tmp = getInlineContainer();
      """),format.raw/*301.7*/("""}"""),format.raw/*301.8*/(""" """),format.raw/*301.9*/("""else """),format.raw/*301.14*/("""{"""),format.raw/*301.15*/("""
        """),format.raw/*302.9*/("""tmp = getInlineContainer('old');
      """),format.raw/*303.7*/("""}"""),format.raw/*303.8*/("""
    """),format.raw/*304.5*/("""}"""),format.raw/*304.6*/(""" """),format.raw/*304.7*/("""else """),format.raw/*304.12*/("""{"""),format.raw/*304.13*/("""
      """),format.raw/*305.7*/("""tmp = getInlineContainer('new');
    """),format.raw/*306.5*/("""}"""),format.raw/*306.6*/("""
    """),format.raw/*307.5*/("""// add comment textarea
    tmp.addClass('inline-comment-form').children('.comment-box-container').html(responseContent);
    $tr.nextAll(':not(.not-diff):first').before(tmp);
    // hide reply comment field
    $(tmp).closest('.not-diff').prev().find('.reply-comment').closest('.not-diff').hide();
    // focus textarea
    tmp.find('textarea').focus();
  """),format.raw/*314.3*/("""}"""),format.raw/*314.4*/(""");
"""),format.raw/*315.1*/("""}"""),format.raw/*315.2*/("""

"""),format.raw/*317.1*/("""function renderOneCommitCommentIntoDiff($v, diff)"""),format.raw/*317.50*/("""{"""),format.raw/*317.51*/("""
  """),format.raw/*318.3*/("""//var filename = $v.attr('filename');
  const oldline = $v.attr('oldline');
  const newline = $v.attr('newline');
  let tmp;
  if (typeof oldline !== 'undefined') """),format.raw/*322.39*/("""{"""),format.raw/*322.40*/("""
    """),format.raw/*323.5*/("""if (typeof newline !== 'undefined') """),format.raw/*323.41*/("""{"""),format.raw/*323.42*/("""
      """),format.raw/*324.7*/("""tmp = getInlineContainer();
    """),format.raw/*325.5*/("""}"""),format.raw/*325.6*/(""" """),format.raw/*325.7*/("""else """),format.raw/*325.12*/("""{"""),format.raw/*325.13*/("""
      """),format.raw/*326.7*/("""tmp = getInlineContainer('old');
    """),format.raw/*327.5*/("""}"""),format.raw/*327.6*/("""
    """),format.raw/*328.5*/("""tmp.children('td:first').html($v.clone().show());
    diff.find('table.diff').find('.oldline[line-number=' + oldline  + ']').parent().nextAll(':not(.not-diff):first').before(tmp);
  """),format.raw/*330.3*/("""}"""),format.raw/*330.4*/(""" """),format.raw/*330.5*/("""else """),format.raw/*330.10*/("""{"""),format.raw/*330.11*/("""
    """),format.raw/*331.5*/("""tmp = getInlineContainer('new');
    tmp.children('td:last').html($v.clone().show());
    diff.find('table.diff').find('.newline[line-number=' + newline  + ']').parent().nextAll(':not(.not-diff):first').before(tmp);
  """),format.raw/*334.3*/("""}"""),format.raw/*334.4*/("""
  """),format.raw/*335.3*/("""if (!diff.find('.toggle-notes').prop('checked')) """),format.raw/*335.52*/("""{"""),format.raw/*335.53*/("""
    """),format.raw/*336.5*/("""tmp.hide();
  """),format.raw/*337.3*/("""}"""),format.raw/*337.4*/("""
"""),format.raw/*338.1*/("""}"""),format.raw/*338.2*/("""

"""),format.raw/*340.1*/("""function renderStatBar(add, del)"""),format.raw/*340.33*/("""{"""),format.raw/*340.34*/("""
  """),format.raw/*341.3*/("""if(add + del > 5)"""),format.raw/*341.20*/("""{"""),format.raw/*341.21*/("""
    """),format.raw/*342.5*/("""if(add)"""),format.raw/*342.12*/("""{"""),format.raw/*342.13*/("""
      """),format.raw/*343.7*/("""if(add < del)"""),format.raw/*343.20*/("""{"""),format.raw/*343.21*/("""
        """),format.raw/*344.9*/("""add = Math.floor(1 + (add * 4 / (add + del)));
      """),format.raw/*345.7*/("""}"""),format.raw/*345.8*/(""" """),format.raw/*345.9*/("""else """),format.raw/*345.14*/("""{"""),format.raw/*345.15*/("""
        """),format.raw/*346.9*/("""add = Math.ceil(1 + (add * 4 / (add + del)));
      """),format.raw/*347.7*/("""}"""),format.raw/*347.8*/("""
    """),format.raw/*348.5*/("""}"""),format.raw/*348.6*/("""
    """),format.raw/*349.5*/("""del = 5 - add;
  """),format.raw/*350.3*/("""}"""),format.raw/*350.4*/("""
  """),format.raw/*351.3*/("""const ret = $('<div class="diffstat-bar">');
  for(let i = 0; i < 5; i++)"""),format.raw/*352.29*/("""{"""),format.raw/*352.30*/("""
    """),format.raw/*353.5*/("""if(add)"""),format.raw/*353.12*/("""{"""),format.raw/*353.13*/("""
      """),format.raw/*354.7*/("""ret.append('<span class="text-diff-added">■</span>');
      add--;
    """),format.raw/*356.5*/("""}"""),format.raw/*356.6*/(""" """),format.raw/*356.7*/("""else if(del)"""),format.raw/*356.19*/("""{"""),format.raw/*356.20*/("""
      """),format.raw/*357.7*/("""ret.append('<span class="text-diff-deleted">■</span>');
      del--;
    """),format.raw/*359.5*/("""}"""),format.raw/*359.6*/(""" """),format.raw/*359.7*/("""else """),format.raw/*359.12*/("""{"""),format.raw/*359.13*/("""
      """),format.raw/*360.7*/("""ret.append('■');
    """),format.raw/*361.5*/("""}"""),format.raw/*361.6*/("""
  """),format.raw/*362.3*/("""}"""),format.raw/*362.4*/("""
  """),format.raw/*363.3*/("""return ret;
"""),format.raw/*364.1*/("""}"""),format.raw/*364.2*/("""

"""),format.raw/*366.1*/("""function renderOneDiff(diffText, viewType, fileHash)"""),format.raw/*366.53*/("""{"""),format.raw/*366.54*/("""
  """),format.raw/*367.3*/("""const table = diffText.closest("table[data-diff-id]");
  const i = table.data("diff-id");
  const ignoreWhiteSpace = table.find('.ignore-whitespace').prop('checked');
  diffUsingJS('oldText-' + i, 'newText-' + i, diffText.attr('id'), viewType, ignoreWhiteSpace, fileHash);
  const add = diffText.find("table").attr("add") * 1;
  const del = diffText.find("table").attr("del") * 1;
  table.find(".diffstat").text(add + del + " ").append(renderStatBar(add, del)).attr("title", add + " additions & " + del + " deletions").tooltip();
  $('span.diffstat[data-diff-id="' + i + '"]')
    .html('<span class="text-diff-added">+' + add + '</span><span class="text-diff-deleted">-' + del + '</span>')
    .append(renderStatBar(add, del).attr('title', (add + del) + " lines changed").tooltip());

  """),_display_(if(hasWritePermission)/*378.26*/ {_display_(Seq[Any](format.raw/*378.28*/("""
    """),format.raw/*379.5*/("""diffText.find('.body').filter(function(i, e) """),format.raw/*379.50*/("""{"""),format.raw/*379.51*/("""
      """),format.raw/*380.7*/("""return $(e).has('span').length > 0;
    """),format.raw/*381.5*/("""}"""),format.raw/*381.6*/(""").each(function()"""),format.raw/*381.23*/("""{"""),format.raw/*381.24*/("""
      """),format.raw/*382.7*/("""$('<b class="add-comment">+</b>').prependTo(this);
    """),format.raw/*383.5*/("""}"""),format.raw/*383.6*/(""");
  """)))} else {null} ),format.raw/*384.4*/("""
  """),_display_(if(showLineNotes)/*385.21*/{_display_(Seq[Any](format.raw/*385.22*/("""
    """),format.raw/*386.5*/("""const fileName = table.attr('filename');
    $('.inline-comment').each(function(i, v) """),format.raw/*387.46*/("""{"""),format.raw/*387.47*/("""
      """),format.raw/*388.7*/("""if($(this).attr('filename') == fileName)"""),format.raw/*388.47*/("""{"""),format.raw/*388.48*/("""
        """),format.raw/*389.9*/("""renderOneCommitCommentIntoDiff($(this), table);
      """),format.raw/*390.7*/("""}"""),format.raw/*390.8*/("""
    """),format.raw/*391.5*/("""}"""),format.raw/*391.6*/(""");
  """)))} else {null} ),format.raw/*392.4*/("""
  """),format.raw/*393.3*/("""return table;
"""),format.raw/*394.1*/("""}"""),format.raw/*394.2*/("""

"""),format.raw/*396.1*/("""function renderReplyComment($table)"""),format.raw/*396.36*/("""{"""),format.raw/*396.37*/("""
  """),format.raw/*397.3*/("""const elements = """),format.raw/*397.20*/("""{"""),format.raw/*397.21*/("""}"""),format.raw/*397.22*/(""";
  let filename, newline, oldline;
  $table.find('.comment-box-container .inline-comment').each(function(i, e)"""),format.raw/*399.76*/("""{"""),format.raw/*399.77*/("""
    """),format.raw/*400.5*/("""filename = $(e).attr('filename');
    newline = $(e).attr('newline');
    oldline = $(e).attr('oldline');
    const key = filename + '-' + newline + '-' + oldline;
    elements[key] = """),format.raw/*404.21*/("""{"""),format.raw/*404.22*/("""
      """),format.raw/*405.7*/("""element: $(e),
      filename: filename,
      newline: newline,
      oldline: oldline
    """),format.raw/*409.5*/("""}"""),format.raw/*409.6*/(""";
  """),format.raw/*410.3*/("""}"""),format.raw/*410.4*/(""");
  for(const key in elements)"""),format.raw/*411.29*/("""{"""),format.raw/*411.30*/("""
    """),format.raw/*412.5*/("""filename = elements[key]['filename'];
    oldline = elements[key]['oldline']; //? elements[key]['oldline'] : '';
    newline = elements[key]['newline']; //? elements[key]['newline'] : '';

    const $v = $('<div class="commit-comment-box reply-comment-box">')
      .append($('<input type="text" class="form-control reply-comment" placeholder="Reply..." '
        + 'data-filename="' + filename + '" '
        + 'data-newline="' + newline + '" '
        + 'data-oldline="' + oldline + '">'));

    let tmp;
    if (typeof oldline !== 'undefined') """),format.raw/*423.41*/("""{"""),format.raw/*423.42*/("""
      """),format.raw/*424.7*/("""if (typeof newline !== 'undefined') """),format.raw/*424.43*/("""{"""),format.raw/*424.44*/("""
        """),format.raw/*425.9*/("""tmp = getInlineContainer();
      """),format.raw/*426.7*/("""}"""),format.raw/*426.8*/(""" """),format.raw/*426.9*/("""else """),format.raw/*426.14*/("""{"""),format.raw/*426.15*/("""
        """),format.raw/*427.9*/("""tmp = getInlineContainer('old');
      """),format.raw/*428.7*/("""}"""),format.raw/*428.8*/("""
      """),format.raw/*429.7*/("""tmp.children('td:first').html($v);
    """),format.raw/*430.5*/("""}"""),format.raw/*430.6*/(""" """),format.raw/*430.7*/("""else """),format.raw/*430.12*/("""{"""),format.raw/*430.13*/("""
      """),format.raw/*431.7*/("""tmp = getInlineContainer('new');
      tmp.children('td:last').html($v);
    """),format.raw/*433.5*/("""}"""),format.raw/*433.6*/("""
    """),format.raw/*434.5*/("""elements[key]['element'].closest('.not-diff').after(tmp);
  """),format.raw/*435.3*/("""}"""),format.raw/*435.4*/("""
"""),format.raw/*436.1*/("""}"""),format.raw/*436.2*/("""

"""),format.raw/*438.1*/("""function renderDiffs() """),format.raw/*438.24*/("""{"""),format.raw/*438.25*/("""
  """),format.raw/*439.3*/("""const diffs = $('.diffText');
  let i = 0;
  function render()"""),format.raw/*441.20*/("""{"""),format.raw/*441.21*/("""
    """),format.raw/*442.5*/("""if (diffs[i]) """),format.raw/*442.19*/("""{"""),format.raw/*442.20*/("""
      """),format.raw/*443.7*/("""const $table = renderOneDiff($(diffs[i]), window.viewType, $('.file-hash')[i].id);
      """),_display_(if(hasWritePermission)/*444.30*/ {_display_(Seq[Any](format.raw/*444.32*/("""
        """),format.raw/*445.9*/("""renderReplyComment($table);
      """)))} else {null} ),format.raw/*446.8*/("""
      """),format.raw/*447.7*/("""i++;
      setTimeout(render);
    """),format.raw/*449.5*/("""}"""),format.raw/*449.6*/(""" """),format.raw/*449.7*/("""else """),format.raw/*449.12*/("""{"""),format.raw/*449.13*/("""
      """),format.raw/*450.7*/("""updateHighlighting();
    """),format.raw/*451.5*/("""}"""),format.raw/*451.6*/("""
  """),format.raw/*452.3*/("""}"""),format.raw/*452.4*/("""
  """),format.raw/*453.3*/("""render();
"""),format.raw/*454.1*/("""}"""),format.raw/*454.2*/("""

"""),format.raw/*456.1*/("""function showDiff(index, fromId, toId, path)"""),format.raw/*456.45*/("""{"""),format.raw/*456.46*/("""
  """),format.raw/*457.3*/("""let url = '"""),_display_(/*457.15*/helpers/*457.22*/.url(repository)),format.raw/*457.38*/("""/diff/';
  if (fromId == '') """),format.raw/*458.21*/("""{"""),format.raw/*458.22*/("""
    """),format.raw/*459.5*/("""url = url + encodeURIComponent(toId);
  """),format.raw/*460.3*/("""}"""),format.raw/*460.4*/(""" """),format.raw/*460.5*/("""else """),format.raw/*460.10*/("""{"""),format.raw/*460.11*/("""
    """),format.raw/*461.5*/("""url = url + encodeURIComponent(fromId) + '...' + encodeURIComponent(toId);
  """),format.raw/*462.3*/("""}"""),format.raw/*462.4*/("""
  """),format.raw/*463.3*/("""$.get(url, """),format.raw/*463.14*/("""{"""),format.raw/*463.15*/(""" """),format.raw/*463.16*/("""path : path """),format.raw/*463.28*/("""}"""),format.raw/*463.29*/(""", function(data) """),format.raw/*463.46*/("""{"""),format.raw/*463.47*/("""
    """),format.raw/*464.5*/("""$('#oldText-' + index).attr('data-val', data.oldContent);
    $('#newText-' + index).attr('data-val', data.newContent);
    const diffs = $('.diffText');
    const $table = renderOneDiff($(diffs[index]), window.viewType, $('.file-hash')[index].id);
    """),_display_(if(hasWritePermission)/*468.28*/ {_display_(Seq[Any](format.raw/*468.30*/("""
      """),format.raw/*469.7*/("""renderReplyComment($table);
    """)))} else {null} ),format.raw/*470.6*/("""
    """),format.raw/*471.5*/("""$('#show-diff-' + index).hide();
  """),format.raw/*472.3*/("""}"""),format.raw/*472.4*/(""");
"""),format.raw/*473.1*/("""}"""),format.raw/*473.2*/("""

"""),format.raw/*475.1*/("""function changeDisplaySetting(key, value)"""),format.raw/*475.42*/("""{"""),format.raw/*475.43*/("""
  """),format.raw/*476.3*/("""let url = '';
  window.params[key] = value;
  for(key in window.params)"""),format.raw/*478.28*/("""{"""),format.raw/*478.29*/("""
    """),format.raw/*479.5*/("""if(window.params[key] != '')"""),format.raw/*479.33*/("""{"""),format.raw/*479.34*/("""
      """),format.raw/*480.7*/("""if(url != '')"""),format.raw/*480.20*/("""{"""),format.raw/*480.21*/("""
        """),format.raw/*481.9*/("""url = url + '&' + key + '=' + window.params[key];
      """),format.raw/*482.7*/("""}"""),format.raw/*482.8*/(""" """),format.raw/*482.9*/("""else """),format.raw/*482.14*/("""{"""),format.raw/*482.15*/("""
        """),format.raw/*483.9*/("""url = url + '?' + key + '=' + window.params[key];
      """),format.raw/*484.7*/("""}"""),format.raw/*484.8*/("""
    """),format.raw/*485.5*/("""}"""),format.raw/*485.6*/("""
  """),format.raw/*486.3*/("""}"""),format.raw/*486.4*/("""
  """),format.raw/*487.3*/("""location.href = url;
"""),format.raw/*488.1*/("""}"""),format.raw/*488.2*/("""

"""),format.raw/*490.1*/("""let scrolling = false;

/**
 * Highlight lines which are specified by URL hash.
 */
function updateHighlighting()"""),format.raw/*495.30*/("""{"""),format.raw/*495.31*/("""
  """),format.raw/*496.3*/("""const hash = location.hash;
  $('tr.highlight').removeClass('highlight');
  if (hash.match(/#diff-(\w+)-[LR]\d+(-[LR]\d+)?/)) """),format.raw/*498.53*/("""{"""),format.raw/*498.54*/("""
    """),format.raw/*499.5*/("""const fragments = hash.substr(1).split('-');
    if (fragments.length == 3) """),format.raw/*500.32*/("""{"""),format.raw/*500.33*/("""
      """),format.raw/*501.7*/("""const tr = $('th#diff-' + fragments[1] + '-' + fragments[2]).closest('tr');
      tr.addClass('highlight');
      if(!scrolling)"""),format.raw/*503.21*/("""{"""),format.raw/*503.22*/("""
        """),format.raw/*504.9*/("""$(window).scrollTop($('th#diff-' + fragments[1] + '-' + fragments[2]).closest('tr').offset().top);
      """),format.raw/*505.7*/("""}"""),format.raw/*505.8*/("""
    """),format.raw/*506.5*/("""}"""),format.raw/*506.6*/(""" """),format.raw/*506.7*/("""else if (fragments.length > 3) """),format.raw/*506.38*/("""{"""),format.raw/*506.39*/("""
      """),format.raw/*507.7*/("""let highlight = false;
      $('th[id^=diff-' + fragments[1] + '-').each(function(i, th) """),format.raw/*508.67*/("""{"""),format.raw/*508.68*/("""
        """),format.raw/*509.9*/("""if (th.id.split('-')[2] == fragments[2]) """),format.raw/*509.50*/("""{"""),format.raw/*509.51*/(""" """),format.raw/*509.52*/("""// start
          highlight = true;
          $(th.closest('tr')).addClass('highlight');
        """),format.raw/*512.9*/("""}"""),format.raw/*512.10*/(""" """),format.raw/*512.11*/("""else if (highlight == true) """),format.raw/*512.39*/("""{"""),format.raw/*512.40*/("""
          """),format.raw/*513.11*/("""if (th.id.split('-')[2] == fragments[3]) """),format.raw/*513.52*/("""{"""),format.raw/*513.53*/(""" """),format.raw/*513.54*/("""// end
            $(th.closest('tr')).addClass('highlight');
            return false;
          """),format.raw/*516.11*/("""}"""),format.raw/*516.12*/(""" """),format.raw/*516.13*/("""else """),format.raw/*516.18*/("""{"""),format.raw/*516.19*/("""
            """),format.raw/*517.13*/("""$(th.closest('tr')).addClass('highlight');
          """),format.raw/*518.11*/("""}"""),format.raw/*518.12*/("""
        """),format.raw/*519.9*/("""}"""),format.raw/*519.10*/("""
      """),format.raw/*520.7*/("""}"""),format.raw/*520.8*/(""");
      if(!scrolling)"""),format.raw/*521.21*/("""{"""),format.raw/*521.22*/("""
        """),format.raw/*522.9*/("""$(window).scrollTop($('th#diff-' + fragments[1] + '-' + fragments[2]).closest('tr').offset().top);
      """),format.raw/*523.7*/("""}"""),format.raw/*523.8*/("""
    """),format.raw/*524.5*/("""}"""),format.raw/*524.6*/("""
  """),format.raw/*525.3*/("""}"""),format.raw/*525.4*/(""" """),format.raw/*525.5*/("""else if (hash != '')"""),format.raw/*525.25*/("""{"""),format.raw/*525.26*/("""
    """),format.raw/*526.5*/("""if (!scrolling) """),format.raw/*526.21*/("""{"""),format.raw/*526.22*/("""
      """),format.raw/*527.7*/("""$(window).scrollTop($(hash).offset().top);
    """),format.raw/*528.5*/("""}"""),format.raw/*528.6*/("""
  """),format.raw/*529.3*/("""}"""),format.raw/*529.4*/("""
  """),format.raw/*530.3*/("""scrolling = true;
"""),format.raw/*531.1*/("""}"""),format.raw/*531.2*/("""
"""),format.raw/*532.1*/("""</script>
"""))
      }
    }
  }

  def render(diffs:Seq[gitbucket.core.util.JGitUtil.DiffInfo],repository:gitbucket.core.service.RepositoryService.RepositoryInfo,newCommitId:Option[String],oldCommitId:Option[String],showIndex:Boolean,issueId:Option[Int],hasWritePermission:Boolean,showLineNotes:Boolean,context:gitbucket.core.controller.Context): play.twirl.api.HtmlFormat.Appendable = apply(diffs,repository,newCommitId,oldCommitId,showIndex,issueId,hasWritePermission,showLineNotes)(context)

  def f:((Seq[gitbucket.core.util.JGitUtil.DiffInfo],gitbucket.core.service.RepositoryService.RepositoryInfo,Option[String],Option[String],Boolean,Option[Int],Boolean,Boolean) => (gitbucket.core.controller.Context) => play.twirl.api.HtmlFormat.Appendable) = (diffs,repository,newCommitId,oldCommitId,showIndex,issueId,hasWritePermission,showLineNotes) => (context) => apply(diffs,repository,newCommitId,oldCommitId,showIndex,issueId,hasWritePermission,showLineNotes)(context)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/gitbucket/core/helper/diff.scala.html
                  HASH: 17edc13a920ae95e5b09c2bbe6d4966088479d31
                  MATRIX: 773->1|1186->343|1229->379|1308->429|1358->451|1387->452|1419->457|1465->476|1493->477|1521->478|1571->501|1610->502|1640->505|1774->612|1814->614|1848->621|1885->631|1901->638|1938->654|1973->662|2005->673|2089->714|2172->770|2212->772|2246->779|2283->789|2299->796|2336->812|2371->820|2403->831|2434->835|2466->846|2550->887|2582->892|2952->1235|2966->1240|2992->1245|3021->1246|3057->1255|3073->1262|3122->1289|3208->1349|3221->1354|3247->1371|3305->1391|3337->1396|3439->1471|3461->1472|3520->1504|3542->1505|3659->1595|3698->1596|3737->1607|3810->1653|3823->1657|3852->1665|3881->1666|3912->1670|3925->1674|3954->1682|4008->1692|4082->1739|4121->1740|4160->1751|4231->1795|4244->1799|4273->1807|4327->1817|4404->1867|4443->1868|4482->1879|4556->1926|4569->1930|4598->1938|4652->1948|4729->1998|4768->1999|4807->2010|4880->2056|4893->2060|4922->2068|4976->2078|5010->2085|5060->2105|5090->2108|5140->2115|5168->2117|5181->2122|5207->2139|5265->2159|5295->2162|5337->2177|5359->2178|5455->2247|5487->2258|5527->2271|5540->2275|5569->2283|5614->2300|5637->2301|5832->2469|5854->2470|6035->2624|6074->2625|6138->2662|6177->2663|6218->2676|6538->2969|6554->2976|6591->2992|6625->2999|6645->3010|6670->3014|6699->3016|6712->3020|6741->3028|6841->3100|6862->3111|6905->3132|7012->3195|7051->3206|7179->3307|7195->3314|7234->3332|7273->3344|7289->3351|7328->3369|7398->3411|7412->3415|7442->3423|7472->3424|7503->3427|7517->3431|7547->3439|7612->3460|7726->3547|7765->3548|7829->3585|7868->3586|7909->3599|8229->3892|8245->3899|8282->3915|8316->3922|8336->3933|8361->3937|8390->3939|8403->3943|8432->3951|8532->4023|8553->4034|8596->4055|8703->4118|8742->4129|8841->4201|8880->4202|8921->4215|8998->4275|9037->4276|9078->4289|9166->4346|9205->4357|9266->4391|9282->4398|9321->4416|9360->4428|9376->4435|9415->4453|9485->4495|9499->4499|9529->4507|9594->4528|9671->4578|9710->4579|9774->4616|9813->4617|9854->4630|10053->4802|10069->4809|10106->4825|10140->4832|10160->4843|10185->4847|10214->4849|10227->4853|10256->4861|10356->4933|10377->4944|10420->4965|10527->5028|10566->5039|10694->5140|10710->5147|10749->5165|10788->5177|10804->5184|10843->5202|10913->5244|10927->5248|10957->5256|11022->5277|11091->5319|11130->5320|11169->5331|11221->5356|11234->5360|11263->5368|11292->5369|11322->5372|11335->5376|11364->5384|11425->5401|11459->5408|11533->5454|11556->5455|11586->5456|11685->5527|11726->5529|11766->5540|11837->5583|11860->5584|11952->5648|11993->5650|12037->5665|12106->5706|12129->5707|12165->5715|12198->5726|12231->5731|12245->5735|12275->5743|12352->5775|12444->5839|12485->5841|12529->5856|12598->5897|12621->5898|12653->5902|12686->5913|12719->5918|12752->5929|12785->5934|12799->5938|12830->5946|12907->5978|12947->5989|13011->6025|13034->6026|13132->6096|13155->6097|13202->6116|13216->6120|13246->6128|13333->6187|13356->6188|13403->6207|13417->6211|13447->6219|13495->6249|13535->6250|13615->6302|13656->6304|13730->6350|13771->6352|13815->6367|13910->6444|13950->6445|13994->6460|14086->6520|14122->6538|14162->6539|14258->6607|14298->6608|14342->6623|14389->6642|14412->6643|14514->6717|14537->6718|14584->6737|14598->6741|14628->6749|14669->6762|14683->6766|14717->6777|14796->6828|14819->6829|14866->6848|14880->6852|14910->6860|14951->6873|14965->6877|14999->6888|15039->6910|15079->6911|15161->6965|15201->6966|15247->6983|15378->7086|15418->7087|15468->7108|15546->7158|15563->7165|15601->7181|15636->7187|15658->7198|15685->7202|15716->7204|15731->7208|15762->7216|15890->7326|15930->7327|16017->7386|16057->7387|16109->7410|16223->7479|16275->7499|16367->7563|16407->7564|16457->7585|16535->7635|16552->7642|16590->7658|16625->7664|16647->7675|16674->7679|16705->7681|16720->7685|16751->7693|16879->7803|16919->7804|17009->7866|17049->7867|17101->7890|17215->7959|17267->7979|17313->7996|17359->8024|17399->8025|17445->8042|17540->8105|17586->8119|17630->8131|17672->8141|17707->8148|17766->8176|17795->8177|17860->8214|17877->8221|17939->8261|17992->8286|18009->8293|18073->8335|18179->8412|18209->8413|18242->8418|18312->8459|18342->8460|18377->8467|18493->8555|18522->8556|18551->8557|18585->8562|18615->8563|18650->8570|18766->8658|18795->8659|18824->8660|18853->8661|18898->8677|18928->8678|18973->8695|19013->8696|19046->8701|19114->8740|19144->8741|19179->8748|19284->8824|19314->8825|19351->8834|19416->8871|19445->8872|19474->8873|19508->8878|19538->8879|19575->8888|19640->8925|19669->8926|19702->8931|19731->8932|19781->8938|19813->8942|19858->8958|19888->8959|19918->8960|20058->9071|20088->9072|20121->9077|20226->9154|20255->9155|20286->9158|20384->9227|20414->9228|20447->9233|20575->9333|20604->9334|20633->9335|20667->9340|20697->9341|20730->9346|20823->9411|20852->9412|20883->9415|20962->9465|20992->9466|21025->9471|21077->9495|21106->9496|21138->9500|21204->9537|21234->9538|21267->9543|21326->9573|21356->9574|21391->9581|21496->9658|21525->9659|21558->9664|21641->9719|21670->9720|21747->9768|21777->9769|21810->9774|21967->9903|21996->9904|22111->9990|22141->9991|22174->9996|22259->10053|22288->10054|22320->10058|22440->10149|22470->10150|22503->10155|22705->10328|22735->10329|22770->10336|22850->10388|22879->10389|22912->10394|23023->10476|23053->10477|23088->10484|23325->10692|23355->10693|23392->10702|23572->10854|23601->10855|23630->10856|23664->10861|23694->10862|23731->10871|23917->11029|23946->11030|23982->11038|24086->11114|24115->11115|24146->11118|24175->11119|24256->11171|24286->11172|24319->11177|24518->11348|24547->11349|24659->11432|24689->11433|24722->11438|25107->11795|25136->11796|25258->11889|25288->11890|25321->11895|25534->12079|25564->12080|25599->12087|25796->12256|25825->12257|25854->12258|25888->12263|25918->12264|25953->12271|26048->12338|26077->12339|26110->12344|26190->12396|26219->12397|26250->12400|26279->12401|26347->12440|26377->12441|26408->12444|26463->12470|26493->12471|26526->12476|26576->12497|26606->12498|26641->12505|26785->12621|26814->12622|26843->12623|26877->12628|26907->12629|26942->12636|27086->12752|27115->12753|27146->12756|27175->12757|27206->12760|27325->12851|27354->12852|27384->12854|27492->12933|27522->12934|27553->12937|27616->12972|27633->12979|27671->12995|27760->13056|27778->13063|27793->13067|27841->13075|27872->13076|27914->13089|27939->13091|27975->13094|28052->13142|28082->13143|28115->13148|28188->13193|28217->13194|28248->13197|28321->13241|28351->13242|28384->13247|28457->13292|28486->13293|28517->13296|28580->13330|28610->13331|28640->13332|28687->13350|28717->13351|28774->13379|28804->13380|28837->13385|28947->13466|28977->13467|29012->13474|29085->13518|29115->13519|29152->13528|29214->13562|29243->13563|29272->13564|29306->13569|29336->13570|29373->13579|29440->13618|29469->13619|29502->13624|29531->13625|29560->13626|29594->13631|29624->13632|29659->13639|29724->13676|29753->13677|29786->13682|30171->14039|30200->14040|30231->14043|30260->14044|30290->14046|30368->14095|30398->14096|30429->14099|30621->14262|30651->14263|30684->14268|30749->14304|30779->14305|30814->14312|30874->14344|30903->14345|30932->14346|30966->14351|30996->14352|31031->14359|31096->14396|31125->14397|31158->14402|31368->14584|31397->14585|31426->14586|31460->14591|31490->14592|31523->14597|31769->14815|31798->14816|31829->14819|31907->14868|31937->14869|31970->14874|32012->14888|32041->14889|32070->14890|32099->14891|32129->14893|32190->14925|32220->14926|32251->14929|32297->14946|32327->14947|32360->14952|32396->14959|32426->14960|32461->14967|32503->14980|32533->14981|32570->14990|32651->15043|32680->15044|32709->15045|32743->15050|32773->15051|32810->15060|32890->15112|32919->15113|32952->15118|32981->15119|33014->15124|33059->15141|33088->15142|33119->15145|33221->15218|33251->15219|33284->15224|33320->15231|33350->15232|33385->15239|33484->15310|33513->15311|33542->15312|33583->15324|33613->15325|33648->15332|33749->15405|33778->15406|33807->15407|33841->15412|33871->15413|33906->15420|33955->15441|33984->15442|34015->15445|34044->15446|34075->15449|34115->15461|34144->15462|34174->15464|34255->15516|34285->15517|34316->15520|35155->16331|35196->16333|35229->16338|35303->16383|35333->16384|35368->16391|35436->16431|35465->16432|35511->16449|35541->16450|35576->16457|35659->16512|35688->16513|35738->16519|35787->16540|35827->16541|35860->16546|35975->16632|36005->16633|36040->16640|36109->16680|36139->16681|36176->16690|36258->16744|36287->16745|36320->16750|36349->16751|36399->16757|36430->16760|36472->16774|36501->16775|36531->16777|36595->16812|36625->16813|36656->16816|36702->16833|36732->16834|36762->16835|36902->16946|36932->16947|36965->16952|37178->17136|37208->17137|37243->17144|37363->17236|37392->17237|37424->17241|37453->17242|37513->17273|37543->17274|37576->17279|38152->17826|38182->17827|38217->17834|38282->17870|38312->17871|38349->17880|38411->17914|38440->17915|38469->17916|38503->17921|38533->17922|38570->17931|38637->17970|38666->17971|38701->17978|38768->18017|38797->18018|38826->18019|38860->18024|38890->18025|38925->18032|39030->18109|39059->18110|39092->18115|39180->18175|39209->18176|39238->18177|39267->18178|39297->18180|39349->18203|39379->18204|39410->18207|39501->18269|39531->18270|39564->18275|39607->18289|39637->18290|39672->18297|39812->18409|39853->18411|39890->18420|39969->18455|40004->18462|40067->18497|40096->18498|40125->18499|40159->18504|40189->18505|40224->18512|40278->18538|40307->18539|40338->18542|40367->18543|40398->18546|40436->18556|40465->18557|40495->18559|40568->18603|40598->18604|40629->18607|40669->18619|40686->18626|40724->18642|40782->18671|40812->18672|40845->18677|40913->18717|40942->18718|40971->18719|41005->18724|41035->18725|41068->18730|41173->18807|41202->18808|41233->18811|41273->18822|41303->18823|41333->18824|41374->18836|41404->18837|41450->18854|41480->18855|41513->18860|41817->19136|41858->19138|41893->19145|41970->19178|42003->19183|42066->19218|42095->19219|42126->19222|42155->19223|42185->19225|42255->19266|42285->19267|42316->19270|42416->19341|42446->19342|42479->19347|42536->19375|42566->19376|42601->19383|42643->19396|42673->19397|42710->19406|42794->19462|42823->19463|42852->19464|42886->19469|42916->19470|42953->19479|43037->19535|43066->19536|43099->19541|43128->19542|43159->19545|43188->19546|43219->19549|43268->19570|43297->19571|43327->19573|43469->19686|43499->19687|43530->19690|43685->19816|43715->19817|43748->19822|43853->19898|43883->19899|43918->19906|44075->20034|44105->20035|44142->20044|44275->20149|44304->20150|44337->20155|44366->20156|44395->20157|44455->20188|44485->20189|44520->20196|44638->20285|44668->20286|44705->20295|44775->20336|44805->20337|44835->20338|44961->20436|44991->20437|45021->20438|45078->20466|45108->20467|45148->20478|45218->20519|45248->20520|45278->20521|45405->20619|45435->20620|45465->20621|45499->20626|45529->20627|45571->20640|45653->20693|45683->20694|45720->20703|45750->20704|45785->20711|45814->20712|45866->20735|45896->20736|45933->20745|46066->20850|46095->20851|46128->20856|46157->20857|46188->20860|46217->20861|46246->20862|46295->20882|46325->20883|46358->20888|46403->20904|46433->20905|46468->20912|46543->20959|46572->20960|46603->20963|46632->20964|46663->20967|46709->20985|46738->20986|46767->20987
                  LINES: 14->1|24->9|25->10|28->11|29->12|29->12|30->13|31->14|31->14|32->15|33->16|33->16|34->17|35->18|35->18|36->19|36->19|36->19|36->19|36->19|36->19|37->20|38->21|38->21|39->22|39->22|39->22|39->22|39->22|39->22|39->22|39->22|40->23|41->24|46->29|46->29|46->29|46->29|46->29|46->29|46->29|48->31|48->31|48->31|48->31|49->32|50->33|50->33|51->34|51->34|52->35|52->35|53->36|53->36|53->36|53->36|53->36|53->36|53->36|53->36|54->37|55->38|55->38|56->39|56->39|56->39|56->39|57->40|58->41|58->41|59->42|59->42|59->42|59->42|60->43|61->44|61->44|62->45|62->45|62->45|62->45|63->46|64->47|66->49|67->50|68->51|69->52|69->52|69->52|69->52|70->53|70->53|70->53|71->54|71->54|71->54|71->54|71->54|71->54|71->54|74->57|74->57|75->58|75->58|76->59|76->59|77->60|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|80->63|82->65|83->66|84->67|84->67|84->67|84->67|84->67|84->67|84->67|84->67|84->67|84->67|84->67|84->67|84->67|85->68|86->69|86->69|87->70|87->70|88->71|91->74|91->74|91->74|91->74|91->74|91->74|91->74|91->74|91->74|91->74|91->74|91->74|93->76|94->77|95->78|95->78|96->79|97->80|97->80|98->81|99->82|100->83|101->84|101->84|101->84|101->84|101->84|101->84|101->84|101->84|101->84|102->85|103->86|103->86|104->87|104->87|105->88|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|107->90|109->92|110->93|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|111->94|112->95|113->96|113->96|114->97|114->97|114->97|114->97|114->97|114->97|114->97|114->97|115->98|116->99|118->101|118->101|118->101|120->103|120->103|121->104|121->104|121->104|122->105|122->105|123->106|123->106|123->106|123->106|123->106|123->106|123->106|123->106|124->107|125->108|125->108|126->109|126->109|126->109|126->109|126->109|126->109|126->109|126->109|126->109|126->109|127->110|128->111|129->112|129->112|130->113|130->113|130->113|130->113|130->113|131->114|131->114|131->114|131->114|131->114|132->115|132->115|133->116|133->116|134->117|134->117|135->118|136->119|136->119|137->120|138->121|139->122|139->122|140->123|140->123|141->124|141->124|141->124|142->125|142->125|142->125|142->125|142->125|142->125|142->125|142->125|143->126|143->126|143->126|143->126|143->126|143->126|143->126|143->126|144->127|144->127|145->128|145->128|146->129|147->130|147->130|148->131|148->131|148->131|148->131|148->131|148->131|148->131|148->131|148->131|148->131|149->132|149->132|150->133|150->133|151->134|152->135|153->136|154->137|154->137|155->138|155->138|155->138|155->138|155->138|155->138|155->138|155->138|155->138|155->138|156->139|156->139|157->140|157->140|158->141|159->142|160->143|161->144|162->145|162->145|163->146|164->147|165->148|166->149|167->150|168->151|171->154|172->155|172->155|172->155|172->155|173->156|173->156|173->156|176->159|176->159|177->160|177->160|177->160|178->161|180->163|180->163|180->163|180->163|180->163|181->164|183->166|183->166|184->167|184->167|186->169|186->169|187->170|187->170|188->171|188->171|188->171|189->172|190->173|190->173|191->174|192->175|192->175|192->175|192->175|192->175|193->176|194->177|194->177|195->178|195->178|196->179|198->181|198->181|198->181|198->181|201->184|201->184|202->185|204->187|204->187|205->188|205->188|205->188|206->189|209->192|209->192|209->192|209->192|209->192|210->193|212->195|212->195|213->196|215->198|215->198|216->199|217->200|217->200|219->202|219->202|219->202|220->203|220->203|220->203|221->204|222->205|222->205|223->206|224->207|224->207|226->209|226->209|227->210|228->211|228->211|230->213|230->213|231->214|232->215|232->215|234->217|235->218|235->218|236->219|239->222|239->222|240->223|241->224|241->224|242->225|242->225|242->225|243->226|246->229|246->229|247->230|249->232|249->232|249->232|249->232|249->232|250->233|252->235|252->235|254->237|255->238|255->238|256->239|256->239|256->239|256->239|257->240|260->243|260->243|263->246|263->246|264->247|272->255|272->255|275->258|275->258|276->259|280->263|280->263|281->264|283->266|283->266|283->266|283->266|283->266|284->267|285->268|285->268|286->269|288->271|288->271|289->272|289->272|291->274|291->274|292->275|292->275|292->275|293->276|293->276|293->276|294->277|295->278|295->278|295->278|295->278|295->278|296->279|297->280|297->280|298->281|298->281|299->282|300->283|300->283|302->285|302->285|302->285|303->286|304->287|304->287|304->287|304->287|304->287|304->287|304->287|304->287|304->287|304->287|304->287|305->288|305->288|306->289|307->290|307->290|308->291|308->291|308->291|309->292|310->293|310->293|311->294|312->295|312->295|312->295|312->295|312->295|312->295|312->295|313->296|315->298|315->298|316->299|316->299|316->299|317->300|318->301|318->301|318->301|318->301|318->301|319->302|320->303|320->303|321->304|321->304|321->304|321->304|321->304|322->305|323->306|323->306|324->307|331->314|331->314|332->315|332->315|334->317|334->317|334->317|335->318|339->322|339->322|340->323|340->323|340->323|341->324|342->325|342->325|342->325|342->325|342->325|343->326|344->327|344->327|345->328|347->330|347->330|347->330|347->330|347->330|348->331|351->334|351->334|352->335|352->335|352->335|353->336|354->337|354->337|355->338|355->338|357->340|357->340|357->340|358->341|358->341|358->341|359->342|359->342|359->342|360->343|360->343|360->343|361->344|362->345|362->345|362->345|362->345|362->345|363->346|364->347|364->347|365->348|365->348|366->349|367->350|367->350|368->351|369->352|369->352|370->353|370->353|370->353|371->354|373->356|373->356|373->356|373->356|373->356|374->357|376->359|376->359|376->359|376->359|376->359|377->360|378->361|378->361|379->362|379->362|380->363|381->364|381->364|383->366|383->366|383->366|384->367|395->378|395->378|396->379|396->379|396->379|397->380|398->381|398->381|398->381|398->381|399->382|400->383|400->383|401->384|402->385|402->385|403->386|404->387|404->387|405->388|405->388|405->388|406->389|407->390|407->390|408->391|408->391|409->392|410->393|411->394|411->394|413->396|413->396|413->396|414->397|414->397|414->397|414->397|416->399|416->399|417->400|421->404|421->404|422->405|426->409|426->409|427->410|427->410|428->411|428->411|429->412|440->423|440->423|441->424|441->424|441->424|442->425|443->426|443->426|443->426|443->426|443->426|444->427|445->428|445->428|446->429|447->430|447->430|447->430|447->430|447->430|448->431|450->433|450->433|451->434|452->435|452->435|453->436|453->436|455->438|455->438|455->438|456->439|458->441|458->441|459->442|459->442|459->442|460->443|461->444|461->444|462->445|463->446|464->447|466->449|466->449|466->449|466->449|466->449|467->450|468->451|468->451|469->452|469->452|470->453|471->454|471->454|473->456|473->456|473->456|474->457|474->457|474->457|474->457|475->458|475->458|476->459|477->460|477->460|477->460|477->460|477->460|478->461|479->462|479->462|480->463|480->463|480->463|480->463|480->463|480->463|480->463|480->463|481->464|485->468|485->468|486->469|487->470|488->471|489->472|489->472|490->473|490->473|492->475|492->475|492->475|493->476|495->478|495->478|496->479|496->479|496->479|497->480|497->480|497->480|498->481|499->482|499->482|499->482|499->482|499->482|500->483|501->484|501->484|502->485|502->485|503->486|503->486|504->487|505->488|505->488|507->490|512->495|512->495|513->496|515->498|515->498|516->499|517->500|517->500|518->501|520->503|520->503|521->504|522->505|522->505|523->506|523->506|523->506|523->506|523->506|524->507|525->508|525->508|526->509|526->509|526->509|526->509|529->512|529->512|529->512|529->512|529->512|530->513|530->513|530->513|530->513|533->516|533->516|533->516|533->516|533->516|534->517|535->518|535->518|536->519|536->519|537->520|537->520|538->521|538->521|539->522|540->523|540->523|541->524|541->524|542->525|542->525|542->525|542->525|542->525|543->526|543->526|543->526|544->527|545->528|545->528|546->529|546->529|547->530|548->531|548->531|549->532
                  -- GENERATED --
              */
          