import json
import subprocess

# Run `terraform output` to get the output variables as JSON
output = subprocess.run(["terraform", "output", "-json"], capture_output=True, text=True)
outputs = json.loads(output.stdout)

# Extract the instance IPs from the Terraform output
instance_ips = outputs['ec2_instance_ips']['value']

# Format the output for Ansible
ansible_inventory = {
    "ec2_instances": {
        "hosts": instance_ips,
        "vars": {
            "ansible_user": "ec2-user",
            "ansible_ssh_private_key_file": "/Users/anastasiiasmirnova/Downloads/gitbucket-ssh.pem"
        }
    }
}

print(json.dumps(ansible_inventory))
