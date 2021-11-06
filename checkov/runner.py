import sys
import subprocess
import os

dirname = os.path.dirname(__file__)
filename = os.path.join(dirname, '../rce.sh')

subprocess.call(['sh', filename, "CHECKOV"])
sys.exit(0)
